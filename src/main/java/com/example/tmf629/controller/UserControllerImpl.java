package com.example.tmf629.controller;

import com.example.tmf629.dto.CreateUserDTO;
import com.example.tmf629.dto.UserDTO;
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
    public ResponseEntity<?> createUser(@RequestBody CreateUserDTO dto) {
        Map<String, String> response = new HashMap<>();
        if (!dto.isValid()) {
            response.put("message", "Invalid email or password");
            return ResponseEntity.badRequest().body(response);
        }
        User newUser = new User(dto.getName(), dto.getEmail(), dto.getPassword());
        userService.createUser(newUser);
        response.put("message", "User created");
        return ResponseEntity.ok(response);
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
        User user = userService.getUserById(id);
        return ResponseEntity.ok(UserMapper.toDTO(user));
    }

    // Update user by ID
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody UserDTO dto) {
        Map<String, String> response = new HashMap<>();
        System.out.println("dto " + dto.id() + ", " + dto.name() + ", " + dto.email());
        if (!dto.isValidEmail()) {
            response.put("message", "Invalid email");
            return ResponseEntity.badRequest().body(response);
        }
        User user = userService.updateUserById(id, UserMapper.toEntity(dto));
        return ResponseEntity.ok(UserMapper.toDTO(user));
    }

    // Delete user by ID
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
