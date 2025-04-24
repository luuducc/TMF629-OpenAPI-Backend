package com.example.tmf629.mapper.characteristic;

import com.example.tmf629.dto.characteristic.CharacteristicDTO;
import com.example.tmf629.model.characteristic.Characteristic;

public class CharacteristicMaper {
    public static CharacteristicDTO toDto(Characteristic entity) {
        return CharacteristicDTO.builder()
                .characteristicRelationship(
                        CharacteristicRelationshipMapper.toDTO(entity.getCharacteristicRelationship())
                )
                .id(entity.getId())
                .name(entity.getName())
                .valueType(entity.getValueType())
                .baseType(entity.getBaseType())
                .type(entity.getType())
                .build();
    }
    public static Characteristic toEntity(CharacteristicDTO dto) {
        return Characteristic.builder()
                .characteristicRelationship(
                        CharacteristicRelationshipMapper.toEntity(dto.getCharacteristicRelationship())
                )
                .id(dto.getId())
                .name(dto.getName())
                .valueType(dto.getValueType())
//                .baseType(dto.getBaseType())
//                .type(dto.getType())
                .build();
    }
}
