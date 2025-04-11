package com.example.tmf629.respository;

import com.example.tmf629.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    User findById(String id);
    List<User> findAll();
    User updateById(String id, User user);
    void deleteById(String id);
    boolean existsByEmail(String email);
    boolean existsById(String id);
}
