package com.example.tmf629.mapper;

import com.example.tmf629.dto.PatchCustomerDTO;
import com.example.tmf629.model.partyrole.Customer;

public class PatchCustomerMapper {
    public static PatchCustomerDTO toPatchCustomerDTO(Customer entity) {
        return new PatchCustomerDTO(
                entity.getName(), entity.getEngagedParty(), entity.getStatus(), entity.getContactMedium()
        );
    }

    public static Customer toEntity(PatchCustomerDTO dto) {
        return Customer.builder()
                .name(dto.getName())
                .engagedParty(dto.getEngagedParty())
                .status(dto.getStatus())
                .contactMedium(dto.getContactMedium())
                .build();
    }
}
