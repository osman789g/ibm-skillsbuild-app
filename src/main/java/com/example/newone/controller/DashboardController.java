package com.example.newone.controller;


import com.example.newone.model.UserEntity;
import com.example.newone.model.Courses;
import com.example.newone.repos.CoursesRepository;
import com.example.newone.repos.UserRepository;
import com.example.newone.service.CourseServiceImpl;
import com.example.newone.service.DailyLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import java.security.Principal;

@Controller
public class DashboardController {
    //repository that has all course information stored in

    private final CoursesRepository coursesRepository;

    private final UserRepository userRepository;

    private final DailyLoginService dailyLoginService;

    private final CourseServiceImpl courseService;

    @Autowired
    public DashboardController(CoursesRepository coursesRepository, UserRepository userRepository, DailyLoginService dailyLoginService, CourseServiceImpl courseService) {
        this.coursesRepository = coursesRepository;
        this.userRepository = userRepository;
        this.dailyLoginService = dailyLoginService;
        this.courseService = courseService;
    }



    //mapping for the dashbaord which passes through all course information to the viewdashboard jsp
    @RequestMapping("/")
    public String viewDashboard(Model model, Principal principal, @RequestParam(name = "topics", required = false) String topics,
                                @RequestParam(name = "search", required = false) String search) {
        // Store courses
        List<Courses> courses;

        // Check if topic filter exists
        if (topics != null && !topics.isEmpty()) {
            courses = coursesRepository.findByTopic(topics);
            // Search for courses by topic
        } else if (search != null && !search.isEmpty()) {
            // Search for courses by name (not full course name and ignore cases).
            courses = coursesRepository.findByCoursenameContainingIgnoreCase(search);
        } else {
            // Display all courses if no topic or search
            courses = (List<Courses>) coursesRepository.findAll();
        }

        // Get all unique topics from the repo
        // 1. Get all the courses from the database 2. Converts list into a split iterator 3. Convert split iterator into a stream
        List<String> allTopics = StreamSupport.stream(coursesRepository.findAll().spliterator(), false)
                // 1. Get topic property 2. only look at non-duplicate topics 3. Then collect them into a list
                .map(Courses::getTopic)
                .distinct()
                .collect(Collectors.toList());

        

        // Check and update user's daily login
        String name = principal.getName();
        UserEntity user = userRepository.findByUsername(name);
        dailyLoginService.updateLoginStreak(user.getId());
        // Add data to model
        model.addAttribute("courselist", courses);
        model.addAttribute("topics", allTopics);
        model.addAttribute("selectedTopic", topics);
        model.addAttribute("streak", userRepository.findByUsername(name).getStreak());
        model.addAttribute("user", user);

        // Returning the Top 3 most popular courses on the site (IBMcourse web application)
        List<Courses> topCourses = courseService.getTopCourses(3); //List<String>topCourses = courseService.getTopCourses(3);
        model.addAttribute("topCourses",topCourses);


        return "viewDashboard";

    }

}
