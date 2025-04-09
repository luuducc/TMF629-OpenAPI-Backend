package com.example.tmf629.mapper;

import com.example.tmf629.dto.UserDTO;
import com.example.tmf629.model.User;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        return new UserDTO(user.getName(), user.getEmail());
    }
    public static User toEntity(UserDTO dto) {
        return new User(dto.getName(), dto.getEmail());
    }
}
