package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.model.UserAuth;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/auth")
    public ResponseEntity<String> getAuth(@RequestBody UserAuth userAuth) {
        String result = userService.getToken(userAuth);
        if(result.equals("Error")) return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
