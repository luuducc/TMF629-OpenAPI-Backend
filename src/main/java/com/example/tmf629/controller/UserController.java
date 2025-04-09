package com.example.tmf629.controller;

import com.example.tmf629.dto.CreateUserDTO;
import com.example.tmf629.dto.UserDTO;
import com.example.tmf629.mapper.UserMapper;
import com.example.tmf629.model.User;
import com.example.tmf629.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

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
    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<User> users = userService.getAllUsers();
        List<UserDTO> userDTOs = users.stream()
                .map(UserMapper::toDTO)
                .toList();
        return ResponseEntity.ok(userDTOs);
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user.get());
    }

    // Update user by ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody UserDTO dto) {
        Map<String, String> response = new HashMap<>();
        if (!dto.isValidEmail()) {
            response.put("message", "Invalid email");
            return ResponseEntity.badRequest().body(response);
        }
        User user = userService.updateUserById(id, UserMapper.toEntity(dto));
        return ResponseEntity.ok(user);
    }

    // Delete user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable String id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }
}
