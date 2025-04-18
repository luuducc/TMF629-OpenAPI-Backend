package com.example.tmf629.mapper.user;

import com.example.tmf629.dto.user.UserDTO;
import com.example.tmf629.model.user.User;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }
    public static User toEntity(UserDTO dto) {
        return new User(dto.id(), dto.name(), dto.email(), "");
    }
}
