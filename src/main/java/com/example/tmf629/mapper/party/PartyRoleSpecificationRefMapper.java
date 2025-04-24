package com.example.tmf629.mapper.party;

import com.example.tmf629.dto.party.PartyRoleSpecificationRefDTO;
import com.example.tmf629.model.party.PartyRoleSpecificationRef;

public class PartyRoleSpecificationRefMapper {
    public static PartyRoleSpecificationRefDTO toDto(PartyRoleSpecificationRef entity) {
        if (entity == null) {
            return null;
        }
        return PartyRoleSpecificationRefDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .baseType(entity.getBaseType())
                .referredType(entity.getReferredType())
                .type(entity.getType())
                .build();
    }
    public static PartyRoleSpecificationRef toEntity(PartyRoleSpecificationRefDTO dto) {
        if (dto == null) {
            return null;
        }
        return PartyRoleSpecificationRef.builder()
                .id(dto.getId())
                .name(dto.getName())
                .baseType(dto.getBaseType())
                .referredType(dto.getReferredType())
                .type(dto.getType())
                .build();
    }
}
