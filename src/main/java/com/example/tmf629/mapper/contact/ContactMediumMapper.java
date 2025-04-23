package com.example.tmf629.mapper.contact;

import com.example.tmf629.dto.contact.*;
import com.example.tmf629.model.contact.*;

public class ContactMediumMapper {
    public static ContactMediumDTO toDTO(ContactMedium entity) {
        if (entity instanceof EmailContactMedium email) {
            return ContactMediumHelper.applyBaseFields(email, EmailContactMediumDTO.builder())
                    .emailAddress(email.getEmailAddress())
                    .build();
        }
        if (entity instanceof FaxContactMedium fax) {
            return ContactMediumHelper.applyBaseFields(fax, FaxContactMediumDTO.builder())
                    .faxNumber(fax.getFaxNumber())
                    .build();
        }
        if (entity instanceof GeographicAddressContactMedium geographicAddress) {
            return ContactMediumHelper.applyBaseFields(geographicAddress, GeographicAddressContactMediumDTO.builder())
                    .city(geographicAddress.getCity())
                    .country(geographicAddress.getCountry())
                    .geographicAddress(geographicAddress.getGeographicAddress())
                    .postCode(geographicAddress.getPostCode())
                    .stateOrProvince(geographicAddress.getStateOrProvince())
                    .street1(geographicAddress.getStreet1())
                    .street2(geographicAddress.getStreet2())
                    .build();
        }
        if (entity instanceof PhoneContactMedium phone) {
            return ContactMediumHelper.applyBaseFields(phone, PhoneContactMediumDTO.builder())
                    .phoneNumber(phone.getPhoneNumber())
                    .build();
        }
        if (entity instanceof SocialContactMedium social) {
            return ContactMediumHelper.applyBaseFields(social, SocialContactMediumDTO.builder())
                    .socialNetworkId(social.getSocialNetworkId())
                    .build();
        }
        return ContactMediumHelper.applyBaseFields(entity, ContactMediumDTO.builder())
                .build();
    }

    public static ContactMedium toEntity(ContactMediumDTO dto) {
        if (dto instanceof EmailContactMediumDTO email) {
            return ContactMediumHelper.applyBaseFields(email, EmailContactMedium.builder())
                    .emailAddress(email.getEmailAddress())
                    .build();
        }
        if (dto instanceof FaxContactMediumDTO fax) {
            return ContactMediumHelper.applyBaseFields(fax, FaxContactMedium.builder())
                    .faxNumber(fax.getFaxNumber())
                    .build();
        }
        if (dto instanceof GeographicAddressContactMediumDTO geographicAddress) {
            return ContactMediumHelper.applyBaseFields(geographicAddress, GeographicAddressContactMedium.builder())
                    .city(geographicAddress.getCity())
                    .country(geographicAddress.getCountry())
                    .geographicAddress(geographicAddress.getGeographicAddress())
                    .postCode(geographicAddress.getPostCode())
                    .stateOrProvince(geographicAddress.getStateOrProvince())
                    .street1(geographicAddress.getStreet1())
                    .street2(geographicAddress.getStreet2())
                    .build();
        }
        if (dto instanceof PhoneContactMediumDTO phone) {
            return ContactMediumHelper.applyBaseFields(phone, PhoneContactMedium.builder())
                    .phoneNumber(phone.getPhoneNumber())
                    .build();
        }
        if (dto instanceof SocialContactMediumDTO social) {
            return ContactMediumHelper.applyBaseFields(social, SocialContactMedium.builder())
                    .socialNetworkId(social.getSocialNetworkId())
                    .build();
        }
        return ContactMediumHelper.applyBaseFields(dto, ContactMedium.builder())
                .build();
    }

    private static class ContactMediumHelper {
        private static <B extends ContactMediumDTO.ContactMediumDTOBuilder<?, ?>> B applyBaseFields(ContactMedium entity, B builder) {
            builder.contactType(entity.getContactType());
            builder.id(entity.getId());
            builder.preferred(entity.isPreferred());
            builder.validFor(entity.getValidFor());
            builder.baseType(entity.getBaseType());
            builder.type(entity.getType());
            return builder;
        }

        private static <B extends ContactMedium.ContactMediumBuilder<?, ?>> B applyBaseFields(ContactMediumDTO dto, B builder) {
            builder.contactType(dto.getContactType());
            builder.id(dto.getId());
            builder.preferred(dto.isPreferred());
            builder.validFor(dto.getValidFor());
            builder.baseType(dto.getBaseType());
            builder.type(dto.getType());
            return builder;
        }
    }
}

