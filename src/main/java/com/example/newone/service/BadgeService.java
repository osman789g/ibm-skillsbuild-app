package com.example.newone.service;

import com.example.newone.model.CourseAttempt;
import com.example.newone.model.UserEntity;
import com.example.newone.model.User_Badge;
import com.example.newone.repos.BadgeRepository;
import com.example.newone.repos.CourseAttemptRepository;
import com.example.newone.repos.UserBadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BadgeService {

    // Repo used to check what courses a user has completed
    @Autowired
    private CourseAttemptRepository courseAttemptRepository;

    // Join table repo used to award badges if necessary
    @Autowired
    private UserBadgeRepository userBadgeRepository;

    // Repo to get information about the different badges
    @Autowired
    private BadgeRepository badgeRepository;

    public void updateBadges(UserEntity user, CourseAttempt courseAttempt) {
        // Get a list of all the User's course attempts
        int userId = courseAttempt.getUserId();
        List<CourseAttempt> attempts = courseAttemptRepository.findByUserId(userId);

        // Check the number of distinct courses completed
        Set<String> distinctCourses = new HashSet<>();
        for (CourseAttempt c : attempts) {
            distinctCourses.add(c.getCourseName());
        }
        int numCourses = distinctCourses.size();

        // Upgrade their completion badge if needed
        // Gold badge for 7-9 completed, silver for 4-6, bronze for 1-3
        if (numCourses == 7) {
            User_Badge oldUserBadge = userBadgeRepository.findByUserAndBadge(user, badgeRepository.findById("Silver Completion").get());
            userBadgeRepository.delete(oldUserBadge);
            User_Badge newBadge = new User_Badge(user, badgeRepository.findById("Gold Completion").get(), LocalDate.now());
            userBadgeRepository.save(newBadge);
        }
        else if (numCourses == 4) {
            User_Badge oldUserBadge = userBadgeRepository.findByUserAndBadge(user, badgeRepository.findById("Bronze Completion").get());
            userBadgeRepository.delete(oldUserBadge);
            User_Badge newBadge = new User_Badge(user, badgeRepository.findById("Silver Completion").get(), LocalDate.now());
            userBadgeRepository.save(newBadge);
        }
        else if (numCourses == 1) {
            User_Badge newBadge = new User_Badge(user, badgeRepository.findById("Bronze Completion").get(), LocalDate.now());
            userBadgeRepository.save(newBadge);
        }

        // AI badge check
        // If the user already has the badge, then skip the check
        if (userBadgeRepository.findByUserAndBadge(user, badgeRepository.findById("AI Expert").get()) == null) {

            // Initialise booleans used to check if all AI courses have been completed
            boolean AIcourse1_completed = false;
            boolean AIcourse2_completed = false;
            boolean AIcourse3_completed = false;

            // Check if they have just completed an AI course
            if (courseAttempt.getCourseName().equals("Getting Started with Enterprise-grade AI") ||
                    courseAttempt.getCourseName().equals("Building Trustworthy AI Enterprise Solutions") ||
                    courseAttempt.getCourseName().equals("Fundamentals of Sustainability and Technology")) {

                // Loop through their course attempts and make sure the attempts have been completed (finishTime != null)
                for (CourseAttempt attempt : attempts) {
                    if (attempt.getFinishTime() != null && (attempt.getCourseName().equals("Getting Started with Enterprise-grade AI") ||
                            attempt.getCourseName().equals("Building Trustworthy AI Enterprise Solutions") ||
                            attempt.getCourseName().equals("Fundamentals of Sustainability and Technology"))) {
                        // If there is a recorded finish time then set the completed values to true.
                        if (attempt.getCourseName().equals("Getting Started with Enterprise-grade AI")) {
                            AIcourse1_completed = true;
                        }
                        if (attempt.getCourseName().equals("Building Trustworthy AI Enterprise Solutions")) {
                            AIcourse2_completed = true;
                        }
                        if (attempt.getCourseName().equals("Fundamentals of Sustainability and Technology")) {
                            AIcourse3_completed = true;
                        }
                    }
                }

                // Apply badge if all AI courses have been completed
                if (AIcourse1_completed && AIcourse2_completed && AIcourse3_completed) {
                    User_Badge badgeEarned = new User_Badge(user, badgeRepository.findById("AI Expert").get(), LocalDate.now());
                    userBadgeRepository.save(badgeEarned);
                }
            }
        }


        // Data Science badge check
        // If the user already has the badge, then skip the check
        if (userBadgeRepository.findByUserAndBadge(user, badgeRepository.findById("DS Expert").get()) == null) {

            // This applies the same logic as the AI badge. Please check those comments to understand the code
            boolean DSCourse1_completed = false;
            boolean DSCourse2_completed = false;
            if (courseAttempt.getCourseName().equals("Getting Started with Enterprise Data Science") ||
                    courseAttempt.getCourseName().equals("Machine Learning for Data Science Projects")) {
                for (CourseAttempt attempt : attempts) {
                    if (attempt.getFinishTime() != null && (attempt.getCourseName().equals("Getting Started with Enterprise Data Science") ||
                            attempt.getCourseName().equals("Machine Learning for Data Science Projects"))) {

                        if (attempt.getCourseName().equals("Getting Started with Enterprise Data Science")) {
                            DSCourse1_completed = true;
                        }
                        if (attempt.getCourseName().equals("Machine Learning for Data Science Projects")) {
                            DSCourse2_completed = true;
                        }
                    }
                }
                if (DSCourse1_completed && DSCourse2_completed) {
                    User_Badge badgeEarned = new User_Badge(user, badgeRepository.findById("DS Expert").get(), LocalDate.now());
                    userBadgeRepository.save(badgeEarned);
                }
            }
        }

        // Cyber Security badge check
        // If the user already has the badge, then skip the check
        if (userBadgeRepository.findByUserAndBadge(user, badgeRepository.findById("Security Expert").get()) == null) {

            // This applies the same logic as the AI badge. Please check those comments to understand the code
            boolean SecurityCourse1_completed = false;
            boolean SecurityCourse2_completed = false;
            if (courseAttempt.getCourseName().equals("Developing Secure Software") ||
                    courseAttempt.getCourseName().equals("Security Operations Center in Practice")) {
                for (CourseAttempt attempt : attempts) {
                    if (attempt.getFinishTime() != null && (attempt.getCourseName().equals("Developing Secure Software") ||
                            attempt.getCourseName().equals("Security Operations Center in Practice"))) {

                        if (attempt.getCourseName().equals("Developing Secure Software")) {
                            SecurityCourse1_completed = true;
                        }
                        if (attempt.getCourseName().equals("Security Operations Center in Practice")) {
                            SecurityCourse2_completed = true;
                        }
                    }
                }
                if (SecurityCourse1_completed && SecurityCourse2_completed) {
                    User_Badge badgeEarned = new User_Badge(user, badgeRepository.findById("Security Expert").get(), LocalDate.now());
                    userBadgeRepository.save(badgeEarned);
                }
            }
        }

        // Cloud Computing badge check
        // If the user already has the badge, then skip the check
        if (userBadgeRepository.findByUserAndBadge(user, badgeRepository.findById("Cloud Expert").get()) == null) {

            // This applies the same logic as the AI badge. Please check those comments to understand the code
            boolean CloudCourse1_completed = false;
            boolean CloudCourse2_completed = false;
            if (courseAttempt.getCourseName().equals("Cloud Computing Fundamentals") ||
                    courseAttempt.getCourseName().equals("DevOps for Enterprise Business Agility")) {
                for (CourseAttempt attempt : attempts) {
                    if (attempt.getFinishTime() != null && (attempt.getCourseName().equals("Cloud Computing Fundamentals") ||
                            attempt.getCourseName().equals("DevOps for Enterprise Business Agility"))) {

                        if (attempt.getCourseName().equals("Cloud Computing Fundamentals")) {
                            CloudCourse1_completed = true;
                        }
                        if (attempt.getCourseName().equals("DevOps for Enterprise Business Agility")) {
                            CloudCourse2_completed = true;
                        }
                    }
                }
                if (CloudCourse1_completed && CloudCourse2_completed) {
                    User_Badge badgeEarned = new User_Badge(user, badgeRepository.findById("Cloud Expert").get(), LocalDate.now());
                    userBadgeRepository.save(badgeEarned);
                }
            }
        }
    }
}
