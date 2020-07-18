package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.model.UserAuth;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(Long id);
    User create(User user);
    String getToken(UserAuth userAuth);
    User getByLogin(String login);
}
