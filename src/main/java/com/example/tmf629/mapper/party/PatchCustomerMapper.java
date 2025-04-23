package com.example.tmf629.mapper.party;

import com.example.tmf629.dto.party.PatchCustomerDTO;
import com.example.tmf629.model.enums.CustomerStatus;
import com.example.tmf629.model.party.Customer;

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
