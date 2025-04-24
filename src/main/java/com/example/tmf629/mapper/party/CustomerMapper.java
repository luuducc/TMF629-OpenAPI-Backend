package com.example.tmf629.mapper.party;

import com.example.tmf629.dto.account.AccountRefDTO;
import com.example.tmf629.dto.agreement.AgreementRefDTO;
import com.example.tmf629.dto.characteristic.CharacteristicDTO;
import com.example.tmf629.dto.credit.CreditProfileDTO;
import com.example.tmf629.dto.party.CustomerDTO;
import com.example.tmf629.dto.contact.ContactMediumDTO;
import com.example.tmf629.dto.party.RelatedPartyOrPartyRoleRefDTO;
import com.example.tmf629.dto.payment.PaymentMethodRefDTO;
import com.example.tmf629.mapper.account.AccountRefMapper;
import com.example.tmf629.mapper.agreement.AgreementRefMapper;
import com.example.tmf629.mapper.characteristic.CharacteristicMaper;
import com.example.tmf629.mapper.contact.ContactMediumMapper;
import com.example.tmf629.mapper.credit.CreditProfileMapper;
import com.example.tmf629.mapper.payment.PaymentMethodRefMapper;
import com.example.tmf629.model.account.AccountRef;
import com.example.tmf629.model.agreement.AgreementRef;
import com.example.tmf629.model.characteristic.Characteristic;
import com.example.tmf629.model.contact.ContactMedium;
import com.example.tmf629.model.credit.CreditProfile;
import com.example.tmf629.model.party.Customer;
import com.example.tmf629.model.party.RelatedPartyOrPartyRoleRef;
import com.example.tmf629.model.payment.PaymentMethodRef;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntFunction;

public class CustomerMapper {
    public static Customer toEntity(CustomerDTO dto) {
        AccountRef[] account = CustomerHelper.mapArray(dto.getAccount(), AccountRefMapper::toEntity, AccountRef[]::new);
        AgreementRef[] agreement = CustomerHelper.mapArray(dto.getAgreement(), AgreementRefMapper::toEntity, AgreementRef[]::new);
        Characteristic[] characteristic = CustomerHelper.mapArray(dto.getCharacteristic(), CharacteristicMaper::toEntity, Characteristic[]::new);
        ContactMedium[] contactMedium = CustomerHelper.mapArray(dto.getContactMedium(), ContactMediumMapper::toEntity, ContactMedium[]::new);
        CreditProfile[] creditProfile = CustomerHelper.mapArray(dto.getCreditProfile(), CreditProfileMapper::toEntity, CreditProfile[]::new);
        PaymentMethodRef[] paymentMethod = CustomerHelper.mapArray(dto.getPaymentMethod(), PaymentMethodRefMapper::toEntity, PaymentMethodRef[]::new);
        RelatedPartyOrPartyRoleRef[] relatedParty = CustomerHelper.mapArray(dto.getRelatedParty(), RelatedPartyOrPartyRoleRefMapper::toEntity, RelatedPartyOrPartyRoleRef[]::new);

        return Customer.builder()
                .account(account)
                .agreement(agreement)
                .characteristic(characteristic)
                .contactMedium(contactMedium)
                .creditProfile(creditProfile)
                .description(dto.getDescription())
                .engagedParty(PartyRefMapper.toEntity(dto.getEngagedParty()))
                .id(dto.getId())
                .name(dto.getName())
                .partyRoleSpecification(PartyRoleSpecificationRefMapper.toEntity(dto.getPartyRoleSpecification()))
                .paymentMethod(paymentMethod)
                .relatedParty(relatedParty)
                .role(dto.getRole())
                .status(dto.getStatus())
                .statusReason(dto.getStatusReason())
                .validFor(dto.getValidFor())
                .type(dto.getType())
                .build();
    }

    public static CustomerDTO toDTO(Customer entity) {
        AccountRefDTO[] account = CustomerHelper.mapArray(entity.getAccount(), AccountRefMapper::toDto, AccountRefDTO[]::new);
        AgreementRefDTO[] agreement = CustomerHelper.mapArray(entity.getAgreement(), AgreementRefMapper::toDto, AgreementRefDTO[]::new);
        CharacteristicDTO[] characteristic = CustomerHelper.mapArray(entity.getCharacteristic(), CharacteristicMaper::toDto, CharacteristicDTO[]::new);
        ContactMediumDTO[] contactMedium = CustomerHelper.mapArray(entity.getContactMedium(), ContactMediumMapper::toDto, ContactMediumDTO[]::new);
        CreditProfileDTO[] creditProfile = CustomerHelper.mapArray(entity.getCreditProfile(), CreditProfileMapper::toDto, CreditProfileDTO[]::new);
        PaymentMethodRefDTO[] paymentMethod = CustomerHelper.mapArray(entity.getPaymentMethod(), PaymentMethodRefMapper::toDto, PaymentMethodRefDTO[]::new);
        RelatedPartyOrPartyRoleRefDTO[] relatedParty = CustomerHelper.mapArray(entity.getRelatedParty(), RelatedPartyOrPartyRoleRefMapper::toDto, RelatedPartyOrPartyRoleRefDTO[]::new);
        return CustomerDTO.builder()
                .account(account)
                .agreement(agreement)
                .characteristic(characteristic)
                .contactMedium(contactMedium)
                .creditProfile(creditProfile)
                .description(entity.getDescription())
                .engagedParty(PartyRefMapper.toDto(entity.getEngagedParty()))
                .id(entity.getId())
                .name(entity.getName())
                .partyRoleSpecification(PartyRoleSpecificationRefMapper.toDto(entity.getPartyRoleSpecification()))
                .paymentMethod(paymentMethod)
                .relatedParty(relatedParty)
                .role(entity.getRole())
                .status(entity.getStatus())
                .statusReason(entity.getStatusReason())
                .validFor(entity.getValidFor())
                .type(entity.getType())
                .build();
    }

    private static class CustomerHelper {
        private static <T, R> R[] mapArray(T[] source, Function<T, R> mapper, IntFunction<R[]> arrayGenerator) {
            if (source == null) {
                return null;
            }
            return Arrays.stream(source)
                    .map(mapper)
                    .toArray(arrayGenerator);
        }
    }
}
