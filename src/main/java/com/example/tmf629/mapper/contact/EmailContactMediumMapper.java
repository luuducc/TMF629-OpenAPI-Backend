package com.example.tmf629.mapper.contact;

import com.example.tmf629.dto.contact.ContactMediumDTO;
import com.example.tmf629.dto.contact.EmailContactMediumDTO;
import com.example.tmf629.model.contact.EmailContactMedium;

public class EmailContactMediumMapper {
    public static EmailContactMediumDTO toDTO(EmailContactMedium entity) {
        EmailContactMediumDTO baseDto = (EmailContactMediumDTO) ContactMediumMapper.toDTO(entity);
        EmailContactMediumDTO dto = baseDto;
        return EmailContactMediumDTO.builder()
                .contactType(entity.getContactType())
                .id(entity.getId())
                .preferred(entity.isPreferred())
                .validFor(entity.getValidFor())
                .baseType(entity.getBaseType())
                .type(entity.getType())
                .emailAddress(entity.getEmailAddress()) // Specific field
                .build();
    }
}
