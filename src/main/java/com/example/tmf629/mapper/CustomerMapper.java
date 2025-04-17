package com.example.tmf629.mapper;

import com.example.tmf629.dto.AccountRefDTO;
import com.example.tmf629.dto.CustomerDTO;
import com.example.tmf629.model.account_ref.AccountRef;
import com.example.tmf629.model.partyrole.Customer;

import java.util.Arrays;

public class CustomerMapper {
    public static Customer toEntity(CustomerDTO dto) {
        AccountRef[] account = null;
        if (dto.getAccount() != null) {
            account = Arrays.stream(dto.getAccount())
                    .map(AccountRefMapper::toEntity)
                    .toArray(AccountRef[]::new);
        }
        return Customer.builder()
                .id(dto.getId())
                .name(dto.getName())
                .type(dto.getType())
                .status(dto.getStatus())
                .engagedParty(dto.getEngagedParty())
                .account(account)
                .contactMedium(dto.getContactMedium())
                .build();
    }

    public static CustomerDTO toDTO(Customer entity) {
        AccountRefDTO[] account = null;
        if (entity.getAccount() != null) {
            account = Arrays.stream(entity.getAccount())
                    .map(AccountRefMapper::toDto)
                    .toArray(AccountRefDTO[]::new);
        }

        return CustomerDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .status(entity.getStatus())
                .type(entity.getType())
                .engagedParty(entity.getEngagedParty())
                .account(account)
                .contactMedium(entity.getContactMedium())
                .build();
    }
}
