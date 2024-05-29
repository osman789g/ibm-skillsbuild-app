package com.example.newone.repos;

import com.example.newone.model.Courses;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoursesRepository extends CrudRepository<Courses, Long> {
    List<Courses> findByTopic(String topic);

    List<Courses> findByCoursenameContainingIgnoreCase(String search);


    Courses findCoursesByCourseId(Long courseId);

    Courses findCoursesByCoursenameContainingIgnoreCase(String courseName);

    

}
