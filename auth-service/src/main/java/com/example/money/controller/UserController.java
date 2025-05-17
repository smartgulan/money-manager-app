package com.example.money.controller;

import com.example.money.model.User;
import com.example.money.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.login(user);
    }

}
