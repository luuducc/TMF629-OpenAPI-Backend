package com.example.tmf629.service;

import com.example.tmf629.dto.CreateUserDTO;
import com.example.tmf629.dto.UserDTO;
import com.example.tmf629.exception.EmailAlreadyUsedException;
import com.example.tmf629.exception.IDNotFoundException;
import com.example.tmf629.mapper.CreateUserMapper;
import com.example.tmf629.mapper.UserMapper;
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
    public UserDTO createUser(CreateUserDTO dto) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new EmailAlreadyUsedException(
                    "Email " + dto.email() + " is already taken"
            );
        }
        User createdUser = userRepository.save(CreateUserMapper.toEntity(dto));
        return UserMapper.toDTO(createdUser);
    }

    // Get all
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Find by id
    @Override
    public UserDTO getUserById(String id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new IDNotFoundException("ID " + id + " not found");
        }
        return UserMapper.toDTO(user);
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
