package com.example.tmf629.service;

import com.example.tmf629.exception.EmailAlreadyUsedException;
import com.example.tmf629.exception.IDNotFoundException;
import com.example.tmf629.model.User;
import com.example.tmf629.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    // Create
    @Override
    public void createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyUsedException(
                    "Email " + user.getEmail() + " is already taken"
            );
        }
         userRepository.save(user);
    }

    // Get all
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Find by id
    @Override
    public User getUserById(String id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new IDNotFoundException("ID " + id + " not found");
        }
        return user;
    }

    // Update by id
    @Override
    public User updateUserById(String id, User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyUsedException(
                    "Email " + user.getEmail() + " is already taken"
            );
        }
        if (!userRepository.existsById(id)) {
            throw new IDNotFoundException("ID " + id + " not found");
        }
        return userRepository.updateById(id, user);
    }

    // Delete by id
    @Override
    public void deleteUserById(String id) {
        if (!userRepository.existsById(id)) {
            throw new IDNotFoundException("ID " + id + " not found");
        }
        userRepository.deleteById(id);
    }
}
