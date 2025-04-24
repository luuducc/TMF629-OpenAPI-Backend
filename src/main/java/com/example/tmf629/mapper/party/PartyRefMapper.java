package com.example.tmf629.mapper.party;

import com.example.tmf629.dto.party.PartyRefDTO;
import com.example.tmf629.model.party.PartyRef;

public class PartyRefMapper {
    public static PartyRef toEntity(PartyRefDTO dto) {
        if (dto == null) {
            return null;
        }
        return PartyRef.builder()
                .id(dto.getId())
                .name(dto.getName())
                .baseType(dto.getBaseType())
                .referredType(dto.getReferredType())
                .type(dto.getType())
                .build();
    }
    public static PartyRefDTO toDto(PartyRef entity) {
        if (entity == null) {
            return null;
        }
        return PartyRefDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .baseType(entity.getBaseType())
                .referredType(entity.getReferredType())
                .type(entity.getType())
                .build();
    }
}
