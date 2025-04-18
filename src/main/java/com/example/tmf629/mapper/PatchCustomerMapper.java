package com.example.tmf629.mapper;

import com.example.tmf629.dto.PatchCustomerDTO;
import com.example.tmf629.enums.CustomerStatus;
import com.example.tmf629.model.partyrole.Customer;

public class PatchCustomerMapper {
    public static Customer toEntity(PatchCustomerDTO dto) {
        return Customer.builder()
                .name(dto.getName())
                .engagedParty(dto.getEngagedParty())
                .status(CustomerStatus.valueOf(dto.getStatus()))
                .contactMedium(dto.getContactMedium())
                .build();
    }
}
