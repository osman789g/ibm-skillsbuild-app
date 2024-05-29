package com.example.newone.controller;

import com.example.newone.model.Avatar;
import com.example.newone.model.UserEntity;
import com.example.newone.repos.AvatarRepository;
import com.example.newone.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
public class AvatarController {
    private final UserRepository userRepository;
    private final AvatarRepository avatarRepository;

    public AvatarController(UserRepository userRepository, AvatarRepository avatarRepository) {
        this.userRepository = userRepository;
        this.avatarRepository = avatarRepository;
    }

    @GetMapping("/getAvatarUrl")
    public ResponseEntity<String> getAvatarUrl(
            @RequestParam(required = false) Long avatarId,
            @RequestParam(required = false) Long userId,
            Principal principal) {

        try {
            if (avatarId != null) {
                return getAvatarUrlById(avatarId);
            } else if (userId != null) {
                return getAvatarUrlByUserId(userId);
            } else if (principal != null) {
                return getAvatarUrlByPrincipal(principal);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    private ResponseEntity<String> getAvatarUrlById(Long avatarId) {
        Avatar avatar = avatarRepository.findById(avatarId).orElse(null);
        if (avatar != null) {
            return ResponseEntity.ok(avatar.getAvatarUrl());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private ResponseEntity<String> getAvatarUrlByUserId(Long userId) {
        Optional<UserEntity> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            Long avatarId = user.getAvatar();
            return getAvatarUrlById(avatarId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private ResponseEntity<String> getAvatarUrlByPrincipal(Principal principal) {
        String username = principal.getName();
        UserEntity user = userRepository.findByUsername(username);
        if (user != null) {
            Long avatarId = user.getAvatar();
            return getAvatarUrlById(avatarId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/changeUserAvatar")
    public ResponseEntity<String> changeUserAvatar(Principal principal, @RequestParam String avatarUrl) {
        try {
            String username = principal.getName();
            UserEntity user = userRepository.findByUsername(username);

            if (user != null) {
                Avatar newAvatarId = avatarRepository.findAvatarIdByAvatarUrl(avatarUrl);
                user.setAvatar(newAvatarId.getAvatarId());
                userRepository.save(user);
                return ResponseEntity.ok("Success");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }




}
