package com.example.demo.service;

import com.example.demo.entity.UserRole;
import com.example.demo.model.UserRoleModel;

import java.util.List;

public interface UserRoleService {
    List<UserRole> findAll();
    UserRole create(UserRole userRole);
    UserRole create(UserRoleModel userRoleModel);
}
