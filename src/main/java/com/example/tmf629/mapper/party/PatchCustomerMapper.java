package com.example.tmf629.mapper.party;

import com.example.tmf629.dto.party.CustomerDTO;
import com.example.tmf629.model.party.Customer;

public class PatchCustomerMapper {
    public static Customer toEntity(CustomerDTO dto) {
        if (dto == null) {
            return null;
        }
        CustomerHelper.MappedCustomerArrays mappedCustomerArrays = com.example.tmf629.mapper.party.CustomerHelper.mapAll(dto);

        return Customer.builder()
                .account(mappedCustomerArrays.account())
                .agreement(mappedCustomerArrays.agreement())
                .characteristic(mappedCustomerArrays.characteristic())
                .contactMedium(mappedCustomerArrays.contactMedium())
                .creditProfile(mappedCustomerArrays.creditProfile())
                .description(dto.getDescription())
                .engagedParty(PartyRefMapper.toEntity(dto.getEngagedParty()))
                .name(dto.getName())
                .partyRoleSpecification(PartyRoleSpecificationRefMapper.toEntity(dto.getPartyRoleSpecification()))
                .paymentMethod(mappedCustomerArrays.paymentMethod())
                .relatedParty(mappedCustomerArrays.relatedParty())
                .role(dto.getRole())
                .status(dto.getStatus())
                .statusReason(dto.getStatusReason())
                .validFor(dto.getValidFor())
                .build();
    }
}
