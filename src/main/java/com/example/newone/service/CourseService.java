package com.example.newone.service;


import com.example.newone.model.Courses;

import java.util.List;

public interface CourseService {
    List<Courses> getTopCourses(int count);

}
