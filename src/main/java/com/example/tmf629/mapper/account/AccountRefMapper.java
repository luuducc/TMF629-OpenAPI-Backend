package com.example.tmf629.mapper.account;

import com.example.tmf629.dto.account.AccountRefDTO;
import com.example.tmf629.model.account.AccountRef;

public class AccountRefMapper {
    public static AccountRefDTO toDto(AccountRef entity) {
        if (entity == null) {
            return null;
        }
        return AccountRefDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .baseType(entity.getBaseType())
                .referredType(entity.getReferredType())
                .type(entity.getType())
                .build();
    }
    public static AccountRef toEntity(AccountRefDTO dto) {
        if (dto == null) {
            return null;
        }
        return AccountRef.builder()
                .id(dto.getId())
                .name(dto.getName())
//                .baseType(dto.getBaseType())
                .referredType(dto.getReferredType())
//                .type(dto.getType())
                .build();
    }
}
