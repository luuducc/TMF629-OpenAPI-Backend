package com.example.tmf629.mapper.user;

import com.example.tmf629.dto.user.CreateUserDTO;
import com.example.tmf629.model.user.User;

public class CreateUserMapper {
    public static User toEntity(CreateUserDTO dto) {
        return new User(dto.email(), dto.name(), dto.password());
    }
}
