package com.example.tmf629.mapper.partyref;

import com.example.tmf629.dto.party.PartyRefDTO;
import com.example.tmf629.model.party.PartyRef;

public class PartyRefMapper {
    public static PartyRef toEntity(PartyRefDTO dto) {
        return PartyRef.builder()
                .id(dto.getId())
                .name(dto.getName())
                .baseType(dto.getBaseType())
                .referredType(dto.getReferredType())
                .type(dto.getType())
                .build();
    }
    public static PartyRefDTO toDto(PartyRef entity) {
        return PartyRefDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .baseType(entity.getBaseType())
                .referredType(entity.getReferredType())
                .type(entity.getType())
                .build();
    }
}
