package com.example.newone.controller;

import com.example.newone.model.UserEntity;
import com.example.newone.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class LeaderboardController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/Leaderboard")
    public String viewLeaderboard(Model model) {
        // Retrieve users sorted by score
        List<UserEntity> users = userRepository.findAll();
        List<UserEntity> sortedUsers = users.stream()
                .sorted(Comparator.comparingInt(UserEntity::getScore).reversed())
                .collect(Collectors.toList());
        model.addAttribute("leaderboard", sortedUsers);
        return "Leaderboard";
    }
}
