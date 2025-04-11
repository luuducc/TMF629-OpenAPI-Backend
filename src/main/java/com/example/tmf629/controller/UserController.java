package com.example.tmf629.controller;

import com.example.tmf629.dto.CreateUserDTO;
import com.example.tmf629.dto.UserDTO;
import com.example.tmf629.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserController {
    ResponseEntity<?> createUser(CreateUserDTO dto);
    ResponseEntity<List<UserDTO>> getUsers();
    ResponseEntity<UserDTO> getUser(String id);
    ResponseEntity<?> updateUser(String id, UserDTO dto);
    ResponseEntity<User> deleteUser(String id);
}
