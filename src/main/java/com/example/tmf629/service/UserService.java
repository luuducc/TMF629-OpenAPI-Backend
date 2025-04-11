package com.example.tmf629.service;

import com.example.tmf629.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    List<User> getAllUsers();
    User getUserById(String id);
    User updateUserById(String id, User user);
    void deleteUserById(String id);
}
