package com.example.newone.service;


import com.example.newone.model.Role;
import com.example.newone.model.UserEntity;
import com.example.newone.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private DailyLoginService dailyLoginService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity domainUser = repository.findByUsername(login);
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role: domainUser.getRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
        }
        dailyLoginService.updateLoginStreak(domainUser.getId());
        return new User(domainUser.getUsername(), domainUser.getPassword(), true, true, true, true, authorities);
    }

}
