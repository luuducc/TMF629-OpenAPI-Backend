package com.example.tmf629.mapper.party;

import com.example.tmf629.dto.party.CustomerDTO;
import com.example.tmf629.model.party.Customer;

public class CustomerMapper {
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
                .id(dto.getId())
                .name(dto.getName())
                .partyRoleSpecification(PartyRoleSpecificationRefMapper.toEntity(dto.getPartyRoleSpecification()))
                .paymentMethod(mappedCustomerArrays.paymentMethod())
                .relatedParty(mappedCustomerArrays.relatedParty())
                .role(dto.getRole())
                .status(dto.getStatus())
                .statusReason(dto.getStatusReason())
                .validFor(dto.getValidFor())
                .type(dto.getType())
                .build();
    }

    public static CustomerDTO toDTO(Customer entity) {
        if (entity == null) {
            return null;
        }
        CustomerHelper.MappedCustomerDtoArrays mappedCustomerDtoArrays = com.example.tmf629.mapper.party.CustomerHelper.mapAll(entity);
        return CustomerDTO.builder()
                .account(mappedCustomerDtoArrays.account())
                .agreement(mappedCustomerDtoArrays.agreement())
                .characteristic(mappedCustomerDtoArrays.characteristic())
                .contactMedium(mappedCustomerDtoArrays.contactMedium())
                .creditProfile(mappedCustomerDtoArrays.creditProfile())
                .description(entity.getDescription())
                .engagedParty(PartyRefMapper.toDto(entity.getEngagedParty()))
                .id(entity.getId())
                .name(entity.getName())
                .partyRoleSpecification(PartyRoleSpecificationRefMapper.toDto(entity.getPartyRoleSpecification()))
                .paymentMethod(mappedCustomerDtoArrays.paymentMethod())
                .relatedParty(mappedCustomerDtoArrays.relatedParty())
                .role(entity.getRole())
                .status(entity.getStatus())
                .statusReason(entity.getStatusReason())
                .validFor(entity.getValidFor())
                .type(entity.getType())
                .build();
    }
}
