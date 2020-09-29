package com.cognizant.controller;

import com.cognizant.model.User;
import com.cognizant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable int userId) {
        return this.userService.getUserById(userId);
    }

    @PostMapping("/login")
    public User login(@RequestBody User u) {
        return this.userService.login(u.getEmail(), u.getPass());
    }

    @PostMapping("/new")
    public User createUser(@RequestBody User u) {
        return this.userService.createUser(u);
    }
}
