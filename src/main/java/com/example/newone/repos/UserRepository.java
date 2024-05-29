package com.example.newone.repos;

import com.example.newone.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

 UserEntity findByEmail(String email);
 UserEntity findByUsername(String userName);
 boolean existsByUsername(String username);


}
