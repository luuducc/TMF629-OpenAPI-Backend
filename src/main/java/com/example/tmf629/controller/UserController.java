package com.example.tmf629.controller;

import com.example.tmf629.dto.CreateUserDTO;
import com.example.tmf629.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserController {
    ResponseEntity<UserDTO> createUser(CreateUserDTO dto);
    ResponseEntity<List<UserDTO>> getUsers();
    ResponseEntity<UserDTO> getUser(String id);
    ResponseEntity<?> updateUser(String id, UserDTO dto);
    ResponseEntity<Void> deleteUser(String id);
}
