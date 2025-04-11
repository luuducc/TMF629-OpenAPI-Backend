package com.example.tmf629.service;

import com.example.tmf629.dto.CreateUserDTO;
import com.example.tmf629.dto.UserDTO;
import com.example.tmf629.model.User;

import java.util.List;

public interface UserService {
    UserDTO createUser(CreateUserDTO dto);
    List<User> getAllUsers();
    UserDTO getUserById(String id);
    UserDTO updateUserById(String id, UserDTO dto);
    void deleteUserById(String id);
}
