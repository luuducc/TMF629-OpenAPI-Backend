package com.example.tmf629.mapper;

import com.example.tmf629.dto.CreateUserDTO;
import com.example.tmf629.model.User;

public class CreateUserMapper {
    public static User toEntity(CreateUserDTO dto) {
        return new User(dto.email(), dto.name(), dto.password());
    }
}
