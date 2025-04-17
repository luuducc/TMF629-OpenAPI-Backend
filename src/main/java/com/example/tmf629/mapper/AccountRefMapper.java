package com.example.tmf629.mapper;

import com.example.tmf629.dto.AccountRefDTO;
import com.example.tmf629.model.account_ref.AccountRef;

public class AccountRefMapper {
    public static AccountRef toEntity(AccountRefDTO dto) {
        return AccountRef.builder()
                .id(dto.getId())
                .name(dto.getName())
                .referredType(dto.getReferredType())
                .baseType(dto.getBaseType())
                .type(dto.getType())
                .build();
    }
    public static AccountRefDTO toDto(AccountRef entity) {
        return AccountRefDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .referredType(entity.getReferredType())
                .baseType(entity.getBaseType())
                .type(entity.getType())
                .build();
    }
}
