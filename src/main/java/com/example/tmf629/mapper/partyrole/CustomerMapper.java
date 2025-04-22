package com.example.tmf629.mapper.partyrole;

import com.example.tmf629.dto.account.AccountRefDTO;
import com.example.tmf629.dto.party.CustomerDTO;
import com.example.tmf629.dto.contact.ContactMediumDTO;
import com.example.tmf629.mapper.accountref.AccountRefMapper;
import com.example.tmf629.mapper.contactmedium.ContactMediumMapper;
import com.example.tmf629.mapper.partyref.PartyRefMapper;
import com.example.tmf629.model.account.AccountRef;
import com.example.tmf629.model.contact.ContactMedium;
import com.example.tmf629.model.party.Customer;

import java.util.Arrays;

public class CustomerMapper {
    public static Customer toEntity(CustomerDTO dto) {
        AccountRef[] account = null;
        if (dto.getAccount() != null) {
            account = Arrays.stream(dto.getAccount())
                    .map(AccountRefMapper::toEntity)
                    .toArray(AccountRef[]::new);
        }

        ContactMedium[] contactMedium = null;
        if (dto.getContactMedium() != null) {
            contactMedium = Arrays.stream(dto.getContactMedium())
                    .map(ContactMediumMapper::toEntity)
                    .toArray(ContactMedium[]::new);
        }

        return Customer.builder()
                .id(dto.getId())
                .name(dto.getName())
                .type(dto.getType())
                .status(dto.getStatus())
                .engagedParty(PartyRefMapper.toEntity(dto.getEngagedParty()))
                .account(account)
                .contactMedium(contactMedium)
                .build();
    }

    public static CustomerDTO toDTO(Customer entity) {
        AccountRefDTO[] account = null;
        if (entity.getAccount() != null) {
            account = Arrays.stream(entity.getAccount())
                    .map(AccountRefMapper::toDto)
                    .toArray(AccountRefDTO[]::new);
        }

        ContactMediumDTO[] contactMedium = null;
        if (entity.getContactMedium() != null) {
            contactMedium = Arrays.stream(entity.getContactMedium())
                    .map(ContactMediumMapper::toDTO)
                    .toArray(ContactMediumDTO[]::new);
        }

        return CustomerDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .status(entity.getStatus())
                .type(entity.getType())
                .baseType(entity.getBaseType())
                .engagedParty(PartyRefMapper.toDto(entity.getEngagedParty()))
                .account(account)
                .contactMedium(contactMedium)
                .build();
    }
}
