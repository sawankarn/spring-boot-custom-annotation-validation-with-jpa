package com.java.puzzle.springbootrestapivalidation.annotation;

import com.java.puzzle.springbootrestapivalidation.entity.User;
import com.java.puzzle.springbootrestapivalidation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ValidUserValidator implements ConstraintValidator<ValidUser, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Optional<User> user = userRepository.findByEmail(value);
        if(value != null && user.isPresent()) return true;
        return false;
    }
}
