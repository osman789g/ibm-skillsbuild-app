package com.example.newone.service;

import com.example.newone.repos.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


    @Service
    public class AccountStatsLogic {
        private final CoursesRepository coursesRepository;

        @Autowired
        public AccountStatsLogic(CoursesRepository coursesRepository) {
            this.coursesRepository = coursesRepository;
        }

        public long getCourseCount(){
            return coursesRepository.count();
        }
    }


