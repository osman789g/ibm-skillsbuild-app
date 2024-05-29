package com.example.newone.repos;

import com.example.newone.model.CourseAttempt;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CourseAttemptRepository extends CrudRepository<CourseAttempt, Long> {
    List<CourseAttempt> findByCourseName(String courseName);

    List<CourseAttempt> findByUserId(int userId);

    List<CourseAttempt> findAllByUserId(int userId);

    List<CourseAttempt> findAllByCourseName(String courseName);


}
