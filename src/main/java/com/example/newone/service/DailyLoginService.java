package com.example.newone.service;
import com.example.newone.model.UserEntity;
import com.example.newone.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class DailyLoginService {

    @Autowired
    private UserRepository userRepository;

    // This method handles the User's daily login streak.
    public int updateLoginStreak(long id) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();

            // If user's login date is null, set it as today
            if(user.getLoginDate() == null) {
                user.setLoginDate(LocalDate.now());
                user.setStreak(1);
                userRepository.save(user);
            }
            else {
                // Check if the User last logged in yesterday. If so, update their streak by +1
                if (user.getLoginDate().equals(LocalDate.now().minusDays(1))) {
                    user.setLoginDate(LocalDate.now());
                    user.setStreak(user.getStreak() + 1);
                }

                // If User's last login was today, then do nothing.
                else if (user.getLoginDate().equals(LocalDate.now())) {
                    // Do nothing
                }

                // User has missed a day - reset streak to 1
                else {
                    user.setLoginDate(LocalDate.now());
                    user.setStreak(1);
                }
                //Save any changes to database
                userRepository.save(user);
                return user.getStreak();
            }
        }
        // If no database entry found, return 0
        return 0;
    }
}
