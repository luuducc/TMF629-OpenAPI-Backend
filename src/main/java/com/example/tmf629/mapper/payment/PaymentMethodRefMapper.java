package com.example.tmf629.mapper.payment;

import com.example.tmf629.dto.payment.PaymentMethodRefDTO;
import com.example.tmf629.model.payment.PaymentMethodRef;

public class PaymentMethodRefMapper {
    public static PaymentMethodRefDTO toDto(PaymentMethodRef entity) {
        return PaymentMethodRefDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .baseType(entity.getBaseType())
                .referredType(entity.getReferredType())
                .type(entity.getType())
                .build();
    }
    public static PaymentMethodRef toEntity(PaymentMethodRefDTO dto) {
        return PaymentMethodRef.builder()
                .id(dto.getId())
                .name(dto.getName())
//                .baseType(dto.getBaseType())
                .referredType(dto.getReferredType())
//                .type(dto.getType())
                .build();
    }
}
