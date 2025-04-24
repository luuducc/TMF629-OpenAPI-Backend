package com.example.tmf629.mapper.credit;

import com.example.tmf629.dto.credit.CreditProfileDTO;
import com.example.tmf629.model.credit.CreditProfile;

public class CreditProfileMapper {
    public static CreditProfileDTO toDto(CreditProfile entity) {
        if (entity == null) {
            return null;
        }
        return CreditProfileDTO.builder()
                .creditProfileDate(entity.getCreditProfileDate())
                .creditRiskRating(entity.getCreditRiskRating())
                .creditScore(entity.getCreditScore())
                .validFor(entity.getValidFor())
                .build();
    }
    public static CreditProfile toEntity(CreditProfileDTO dto) {
        if (dto == null) {
            return null;
        }
        return CreditProfile.builder()
                .creditProfileDate(dto.getCreditProfileDate())
                .creditRiskRating(dto.getCreditRiskRating())
                .creditScore(dto.getCreditScore())
                .validFor(dto.getValidFor())
                .build();
    }
}
