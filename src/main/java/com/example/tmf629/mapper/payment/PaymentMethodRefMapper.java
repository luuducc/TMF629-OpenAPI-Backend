package com.example.tmf629.mapper.payment;

import com.example.tmf629.dto.payment.PaymentMethodRefDTO;
import com.example.tmf629.model.payment.PaymentMethodRef;

public class PaymentMethodRefMapper {
    public PaymentMethodRefDTO toDto(PaymentMethodRef entity) {
        return PaymentMethodRefDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .baseType(entity.getBaseType())
                .referredType(entity.getReferredType())
                .type(entity.getType())
                .build();
    }
    public PaymentMethodRef toEntity(PaymentMethodRefDTO dto) {
        return PaymentMethodRef.builder()
                .id(dto.getId())
                .name(dto.getName())
//                .baseType(dto.getBaseType())
                .referredType(dto.getReferredType())
//                .type(dto.getType())
                .build();
    }
}
