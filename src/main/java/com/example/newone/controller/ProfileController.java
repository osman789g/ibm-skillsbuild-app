package com.example.newone.controller;

import com.example.newone.model.Avatar;
import com.example.newone.model.Badge;
import com.example.newone.model.UserEntity;
import com.example.newone.model.User_Badge;
import com.example.newone.repos.AvatarRepository;
import com.example.newone.repos.UserBadgeRepository;
import com.example.newone.repos.UserRepository;
import com.example.newone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProfileController {
    private final UserService userService;
    public ProfileController(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AvatarRepository avatarRepository;

    @Autowired
    private UserBadgeRepository userBadgeRepository;

    @GetMapping("/profile")
    public String viewProfile(Model model, Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            UserEntity user = userRepository.findByUsername(username);
            if (user != null) {
                model.addAttribute("user", user);

                List<User_Badge> badges = userBadgeRepository.findByUser(user);
                List<Badge> badges1 = new ArrayList<>();
                for (User_Badge b : badges) {
                    badges1.add(b.getBadge());
                }
                model.addAttribute("badges", badges1);

                Long avatarId = user.getAvatar();
                Avatar avatar = avatarRepository.findById(avatarId).orElse(null);
                if (avatar != null) {
                    model.addAttribute("avatarUrl", avatar.getAvatarUrl());
                } else {
                    model.addAttribute("avatarUrl", "default-avatar-url.png");
                }
            } else {
                return "redirect:/login";
            }
        } else {
            return "redirect:/login";
        }
        return "profile";
    }

    // Handler method to show the edit form for the username
    @GetMapping("/profile/edit")
    public String showEditProfileForm(Model model, Principal principal) {
        if (principal != null) {
            String username = principal.getName();
            UserEntity user = userService.findByUsername(username);
            if (user != null) {
                model.addAttribute("user", user);

                // Get the level of the user
                int score = user.getScore();

                // Get avatar URLs for levels 1 to user's level
                List<Avatar> avatars = avatarRepository.findByAvatarIdLessThanEqual((long) score);
                List<String> avatarUrls = avatars.stream()
                        .map(Avatar::getAvatarUrl)
                        .collect(Collectors.toList());

                model.addAttribute("avatarUrls", avatarUrls);

                return "editProfile";
            }
        }
        return "redirect:/login";
    }



    // Handler method to process the username update
    @PostMapping("/profile/update")
    public String updateProfile(@RequestParam("newUsername") String newUsername, Principal principal, RedirectAttributes redirectAttributes) {
        if (principal != null) {
            String currentUsername = principal.getName();
            UserEntity user = userService.findByUsername(currentUsername);
            if (user != null) {
                if (userService.existsByUsername(newUsername) && !currentUsername.equals(newUsername)) {
                    // Username already exists and is not the current username
                    redirectAttributes.addFlashAttribute("errorMessage", "This username is already taken. Please choose another username.");
                    return "redirect:/profile/edit";
                }

                // Proceed with the update since the new username is either the same as the current
                // or it's new and not yet taken
                user.setUsername(newUsername); //Updates username in database
                userService.updateUser(user);

                // Re-authenticates user with the new username and credentials
                Authentication currentAuth = SecurityContextHolder.getContext().getAuthentication();
                Authentication newAuth = new UsernamePasswordAuthenticationToken(newUsername, currentAuth.getCredentials(), currentAuth.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(newAuth);
                redirectAttributes.addFlashAttribute("successMessage", "Profile updated successfully!");
                return "redirect:/profile";
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "User not found!");
            }
        }
        return "redirect:/login";
    }


}