package com.example.newone.controller;

import com.example.newone.model.CourseAttempt;
import com.example.newone.model.UserEntity;
import com.example.newone.repos.BadgeRepository;
import com.example.newone.repos.CourseAttemptRepository;
import com.example.newone.repos.UserBadgeRepository;
import com.example.newone.repos.UserRepository;
import com.example.newone.repos.CoursesRepository;
import com.example.newone.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.security.Principal;
import java.util.stream.Collectors;


@Controller
public class CourseController {

    @Autowired
    private CourseAttemptRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private UserBadgeRepository userBadgeRepository;

    @Autowired
    private BadgeRepository badgeRepository;

    //BadgeService is needed to check and update a user's badges.
    @Autowired
    private BadgeService badgeService;

    @RequestMapping("/startCourse")
    public String startCourseAttempt(Principal principal, @RequestParam String courseName, @RequestParam String courseLink ,Model model) {
        CourseAttempt courseAttempt = new CourseAttempt();
        String name = principal.getName();
        UserEntity user = userRepository.findByUsername(name);
        courseAttempt.setUserId(user.getId().intValue());
        courseAttempt.setCourseName(courseName);

        courseAttempt.setCourseLink(courseLink);
        courseAttempt.setStartTime(LocalDateTime.now());

        CourseAttempt savedAttempt = repository.save(courseAttempt);
        model.addAttribute("courseLink", courseLink);
        model.addAttribute("courseAttempt", savedAttempt);
        return "courseRedirect";
    }


    @GetMapping("/courseAttempts")
    public String getCourseAttempt(Principal principal, Model model) {
        String name = principal.getName();
        UserEntity user = userRepository.findByUsername(name);

        List<CourseAttempt> courseAttempts = repository.findAllByUserId(user.getId().intValue());
        model.addAttribute("courseAttempts", courseAttempts);

        return "courseAttempts";
    }


    @RequestMapping("/finishCourse")
    public String finishCourseAttempt(@RequestParam String courseName, Principal principal) {
        String name = principal.getName();
        UserEntity user = userRepository.findByUsername(name);
        List<CourseAttempt> courseAttempts = repository.findByUserId(user.getId().intValue());

        if (courseAttempts == null) {
            return "courseRedirect";
        }
        List<CourseAttempt> filteredCourseAttempts = courseAttempts.stream()
                .filter(courseAttempt -> courseAttempt.getCourseName().equals(courseName))
                .collect(Collectors.toList());

        if (filteredCourseAttempts.isEmpty()) {
            return "courseRedirect";
        }

        CourseAttempt courseAttempt = filteredCourseAttempts.get(filteredCourseAttempts.size() - 1);


        LocalDateTime finishTime = LocalDateTime.now();
        courseAttempt.setFinishTime(finishTime);
        courseAttempt.setDurationInSeconds(calculateDuration(courseAttempt.getStartTime(), finishTime));
        user.setScore(user.getScore() + 1);
        userRepository.save(user);
        repository.save(courseAttempt);

        // Call method to check if the User has earned a badge.
        badgeService.updateBadges(user, courseAttempt);
        return "courseRedirect";
    }


    private long calculateDuration(LocalDateTime startTime, LocalDateTime finishTime) {
        return startTime.until(finishTime, java.time.temporal.ChronoUnit.SECONDS);
    }
}
