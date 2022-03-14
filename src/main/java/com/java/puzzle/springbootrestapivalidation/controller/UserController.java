package com.java.puzzle.springbootrestapivalidation.controller;

import com.java.puzzle.springbootrestapivalidation.annotation.ValidUser;
import com.java.puzzle.springbootrestapivalidation.dto.LoginRequest;
import com.java.puzzle.springbootrestapivalidation.entity.User;
import com.java.puzzle.springbootrestapivalidation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        User userResponse = userService.createUser(user);
        return new ResponseEntity<User>(userResponse, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody @Valid LoginRequest loginRequest){
        String validUser = userService.loginUser(loginRequest);
        return new ResponseEntity<>(validUser, HttpStatus.OK);
    }
}
