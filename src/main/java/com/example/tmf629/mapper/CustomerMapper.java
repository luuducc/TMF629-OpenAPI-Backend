package com.example.tmf629.mapper;

import com.example.tmf629.dto.CustomerDTO;
import com.example.tmf629.model.partyrole.Customer;

public class CustomerMapper {
    public static Customer toEntity(CustomerDTO dto) {
        return Customer.builder()
                .id(dto.getId())
                .name(dto.getName())
                .type(dto.getType())
                .status(dto.getStatus())
                .engagedParty(dto.getEngagedParty())
                .contactMedium(dto.getContactMedium())
                .build();
    }

    public static Customer toEntityForUpdate(CustomerDTO dto) {
        return Customer.builder()
                .name(dto.getName())
                .status(dto.getStatus())
                .engagedParty(dto.getEngagedParty())
                .contactMedium(dto.getContactMedium())
                .build();
    }

    public static CustomerDTO toDTO(Customer entity) {
        return CustomerDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .status(entity.getStatus())
                .type(entity.getType())
                .engagedParty(entity.getEngagedParty())
                .contactMedium(entity.getContactMedium())
                .build();
    }
}
