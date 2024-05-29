package com.example.newone.service;

import com.example.newone.model.CourseAttempt;
import com.example.newone.model.Courses;
import com.example.newone.repos.CourseAttemptRepository;
import com.example.newone.repos.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements  CourseService {
    //Used repositories
    private final CoursesRepository coursesRepository;


    private final CourseAttemptRepository courseAttemptRepository;


    private final AccountStatsLogic accountStatsLogic;

    //Constructor
    @Autowired
    public CourseServiceImpl(CoursesRepository coursesRepository, CourseAttemptRepository courseAttemptRepository, AccountStatsLogic accountStatsLogic) {
        this.coursesRepository = coursesRepository;
        this.courseAttemptRepository = courseAttemptRepository;
        this.accountStatsLogic = accountStatsLogic;
    }




    @Override
    public List<Courses> getTopCourses(int count) {
        long NumberOfCourses = accountStatsLogic.getCourseCount();

        Map<String,Long> courseCountMap = new HashMap<>(); // Dictionary to Store the number of entries each individual course has in courseAttempt table.

        // Determine the total time spent on each course
        for(long i= 1;i<NumberOfCourses;i++){
            Courses temp = coursesRepository.findCoursesByCourseId(i);
            List<CourseAttempt> courseAttemptList = courseAttemptRepository.findAllByCourseName(temp.getCoursename());

            for (CourseAttempt courseAttempt : courseAttemptList) {
                String courseName = courseAttempt.getCourseName();
                long timeSpent = courseAttempt.getDurationInSeconds();

                // Accumulate the time spent on the course
                courseCountMap.put(courseName, courseCountMap.getOrDefault(courseName, 0L) + timeSpent);
            }
        }

        // Determining the Top 3 courses(Using functional & Declarative style programming with Stream)
        List<String> topCourses = courseCountMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(count)// changed to variable instead of a constant, for wider usage.
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        // Linking Each entry in topCourses to its corresponding Course entity
        List<Courses> topCoursesEntities = new ArrayList<>();
        for (String courseName:topCourses){
            topCoursesEntities.add(coursesRepository.findCoursesByCoursenameContainingIgnoreCase(courseName));
        }

        return topCoursesEntities;
    }
}

/*    @Override
    public List<Courses> getTopCourses(int count) {
        long NumberOfCourses = accountStatsLogic.getCourseCount();

        Map<String,Long> courseCountMap = new HashMap<>(); // Dictionary to Store the number of entries each individual course has in courseAttempt table.

        // Determine the total time spent on each course
        for(long i= 1;i<NumberOfCourses;i++){
            Courses temp = coursesRepository.findCoursesByCourseId(i);
            List<CourseAttempt> courseAttemptList = courseAttemptRepository.findAllByCourseName(temp.getCoursename());

            for (CourseAttempt courseAttempt : courseAttemptList) {
                String courseName = courseAttempt.getCourseName();
                long timeSpent = courseAttempt.getDurationInSeconds();

                // Accumulate the time spent on the course
                courseCountMap.put(courseName, courseCountMap.getOrDefault(courseName, 0L) + timeSpent);
            }
        }

        // Determining the Top 3 courses(Using functional & Declarative style programming with Stream)
        List<String> topCourses = courseCountMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(count)// changed to variable instead of a constant, for wider usage.
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        // Linking Each entry in topCourses to its corresponding Course entity
        List<Courses> topCoursesEntities = new ArrayList<>();
        for (String courseName:topCourses){
            topCoursesEntities.add(coursesRepository.findCoursesByCoursenameContainingIgnoreCase(courseName));
        }


        return topCoursesEntities;
    }
}*/
