package com.jpa.jpaexample.controller;


import com.jpa.jpaexample.model.User;
import com.jpa.jpaexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spring-jpa-example")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> users=userService.getAllUsersFromDB();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getUsers/{keyword}")
    public ResponseEntity<List<User>> SearchUsers(@PathVariable String keyword){
        List<User> users=userService.getUsersByStrategy(keyword);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
