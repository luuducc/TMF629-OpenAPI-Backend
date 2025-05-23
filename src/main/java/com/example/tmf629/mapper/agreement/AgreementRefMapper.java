package com.example.tmf629.mapper.agreement;

import com.example.tmf629.dto.agreement.AgreementRefDTO;
import com.example.tmf629.model.agreement.AgreementRef;

public class AgreementRefMapper {
    public static AgreementRefDTO toDto(AgreementRef entity) {
        if (entity == null) {
            return null;
        }
        return AgreementRefDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .baseType(entity.getBaseType())
                .referredType(entity.getReferredType())
                .type(entity.getType())
                .build();
    }
    public static AgreementRef toEntity(AgreementRefDTO dto) {
        if (dto == null) {
            return null;
        }
        return AgreementRef.builder()
                .id(dto.getId())
                .name(dto.getName())
//                .baseType(dto.getBaseType())
                .referredType(dto.getReferredType())
//                .type(dto.getType())
                .build();
    }
}
