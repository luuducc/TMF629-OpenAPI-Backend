package com.example.tmf629.mapper.contactmedium;

import com.example.tmf629.dto.contact.ContactMediumDTO;
import com.example.tmf629.model.contact.ContactMedium;

public class ContactMediumMapper {
    public static ContactMediumDTO toDTO(ContactMedium entity) {
        return ContactMediumDTO.builder()
                .contactType(entity.getContactType())
                .id(entity.getId())
                .preferred(entity.isPreferred())
                .validFor(entity.getValidFor())
                .baseType(entity.getBaseType())
                .type(entity.getType())
                .build();
    }
    public static ContactMedium toEntity(ContactMediumDTO dto) {
        return ContactMedium.builder()
                .contactType(dto.getContactType())
                .preferred(dto.isPreferred())
                .validFor(dto.getValidFor())
                .type(dto.getType())
                .build();
    }
}
