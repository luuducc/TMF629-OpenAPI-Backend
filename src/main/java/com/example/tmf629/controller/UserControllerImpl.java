package com.example.tmf629.controller;

import com.example.tmf629.dto.CreateUserDTO;
import com.example.tmf629.dto.UserDTO;
import com.example.tmf629.exception.InvalidInputException;
import com.example.tmf629.mapper.UserMapper;
import com.example.tmf629.model.User;
import com.example.tmf629.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {
    @Autowired
    private UserServiceImpl userService;

    @Override
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTO dto) {
        if (!dto.isValid()) {
            throw new InvalidInputException("Email or password is invalid");
        }
        UserDTO createdUser = userService.createUser(dto);
        return ResponseEntity.ok(createdUser);
    }

    // Get all user
    @Override
    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<User> users = userService.getAllUsers();
        List<UserDTO> userDTOs = users.stream()
                .map(UserMapper::toDTO)
                .toList();
        return ResponseEntity.ok(userDTOs);
    }

    // Get user by ID
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable String id) {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // Update user by ID
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String id, @RequestBody UserDTO dto) {
        if (dto.email() != null && !dto.isValidEmail()) {
            throw new InvalidInputException("Email is invalid");
        }
        UserDTO updatedUser = userService.updateUserById(id, dto);
        return ResponseEntity.ok(updatedUser);
    }

    // Delete user by ID
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
