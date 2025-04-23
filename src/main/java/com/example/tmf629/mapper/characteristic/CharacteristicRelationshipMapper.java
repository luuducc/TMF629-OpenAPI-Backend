package com.example.tmf629.mapper.characteristic;

import com.example.tmf629.dto.characteristic.CharacteristicRelationshipDTO;
import com.example.tmf629.model.characteristic.CharacteristicRelationship;

public class CharacteristicRelationshipMapper {
    public static CharacteristicRelationshipDTO toDTO(CharacteristicRelationship entity) {
        return CharacteristicRelationshipDTO.builder()
                .id(entity.getId())
                .relationshipType(entity.getRelationshipType())
                .baseType(entity.getBaseType())
                .type(entity.getType())
                .build();
    }
    public static CharacteristicRelationship toEntity(CharacteristicRelationshipDTO dto) {
        return CharacteristicRelationship.builder()
                .id(dto.getId())
                .relationshipType(dto.getRelationshipType())
//                .baseType(dto.getBaseType())
//                .type(dto.getType())
                .build();
    }
}
