package com.example.newone.repos;

import com.example.newone.model.Badge;
import com.example.newone.model.UserEntity;
import com.example.newone.model.User_Badge;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserBadgeRepository extends CrudRepository<User_Badge, Integer> {
    // Find all badges that a user owns
    List<User_Badge> findByUser(UserEntity user);

    // Check if a specific user owns a specific badge
    User_Badge findByUserAndBadge(UserEntity user, Badge badge);
}
