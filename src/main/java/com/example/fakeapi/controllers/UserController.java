package com.example.fakeapi.controllers;

import com.example.fakeapi.DTO.User;
import com.example.fakeapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> users() {
        return userService.getAllUsers();
    }

    @PostMapping
    public void create(@RequestBody User user) {
        userService.createNewUser(user);
    }

    @PutMapping(path = "{userId}")
    public void update(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String name
    ) {
        userService.update(userId, name);
    }

    @DeleteMapping("{userId}")
    public void delete(@PathVariable("userId") Long userId) {
        userService.delete(userId);
    }

}

