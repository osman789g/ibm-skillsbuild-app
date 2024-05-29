package com.example.newone.service;

import com.example.newone.dto.RegistrationDto;
import com.example.newone.model.UserEntity;

//Write here any user specific crud methods you think user entity will need for your part
public interface UserService {

    void saveUser(RegistrationDto registrationDto);
    void updateUser(UserEntity userEntity);
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
    boolean existsByUsername(String username);
}
