package com.example.tmf629.service;

import com.example.tmf629.exception.EmailAlreadyUsedException;
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
    public void createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyUsedException(
                    "Email " + user.getEmail() + " is already taken"
            );
        }
         userRepository.save(user);
    }

    // Get all
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Find by id
    public Optional<User> getUserById(String id) {
        User user = userRepository.findById(id);
        if (user == null) {
            return Optional.empty();
        }
        return Optional.of(userRepository.findById(id));
    }

    // Update by id
    public User updateUserById(String id, User user) {
        return userRepository.updateById(id, user);
    }

    // Delete by id
    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }
}
