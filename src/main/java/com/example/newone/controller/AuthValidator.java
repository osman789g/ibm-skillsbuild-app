package com.example.newone.controller;



import com.example.newone.dto.RegistrationDto;
import com.example.newone.model.UserEntity;
import com.example.newone.service.UserService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AuthValidator implements Validator {


    private final UserService userService;

    public AuthValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return RegistrationDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegistrationDto user = (RegistrationDto) target;

        ValidationUtils.rejectIfEmpty(errors,"username","","The field cannot be empty.Please provide input");

        ValidationUtils.rejectIfEmpty(errors,"password","","The field cannot be empty.Please provide input");

        ValidationUtils.rejectIfEmpty(errors,"email","","The field cannot be empty.Please provide input");

        UserEntity existingUserEmail = userService.findByEmail(user.getEmail());
        if(existingUserEmail != null) {
            errors.rejectValue("email", "","There is already a user registered with this email");

        }

        UserEntity existingUserUsername = userService.findByUsername(user.getUsername());
        if(existingUserUsername != null) {
            errors.rejectValue("username", "","There is already a user registered with this username ");

        }
    }

}
