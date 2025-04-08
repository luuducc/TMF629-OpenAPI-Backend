package com.example.tmf629.service;

import com.example.tmf629.model.User;
import com.example.tmf629.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Create
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Read all
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Read by id
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    // Update
    public User updateUser(String id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    // Delete
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
