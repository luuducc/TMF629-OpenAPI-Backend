package com.example.tmf629.mapper.party;

import com.example.tmf629.dto.account.AccountRefDTO;
import com.example.tmf629.dto.agreement.AgreementRefDTO;
import com.example.tmf629.dto.characteristic.CharacteristicDTO;
import com.example.tmf629.dto.contact.ContactMediumDTO;
import com.example.tmf629.dto.credit.CreditProfileDTO;
import com.example.tmf629.dto.party.CustomerDTO;
import com.example.tmf629.dto.party.RelatedPartyOrPartyRoleRefDTO;
import com.example.tmf629.dto.payment.PaymentMethodRefDTO;
import com.example.tmf629.mapper.account.AccountRefMapper;
import com.example.tmf629.mapper.agreement.AgreementRefMapper;
import com.example.tmf629.mapper.characteristic.CharacteristicMapper;
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

public class CustomerHelper {
    public static MappedCustomerArrays mapAll(CustomerDTO dto) {
        return new MappedCustomerArrays(
                mapArray(dto.getAccount(), AccountRefMapper::toEntity, AccountRef[]::new),
                mapArray(dto.getAgreement(), AgreementRefMapper::toEntity, AgreementRef[]::new),
                mapArray(dto.getCharacteristic(), CharacteristicMapper::toEntity, Characteristic[]::new),
                mapArray(dto.getContactMedium(), ContactMediumMapper::toEntity, ContactMedium[]::new),
                mapArray(dto.getCreditProfile(), CreditProfileMapper::toEntity, CreditProfile[]::new),
                mapArray(dto.getPaymentMethod(), PaymentMethodRefMapper::toEntity, PaymentMethodRef[]::new),
                mapArray(dto.getRelatedParty(), RelatedPartyOrPartyRoleRefMapper::toEntity, RelatedPartyOrPartyRoleRef[]::new)
        );
    }

    public static MappedCustomerDtoArrays mapAll(Customer entity) {
        return new MappedCustomerDtoArrays(
                mapArray(entity.getAccount(), AccountRefMapper::toDto, AccountRefDTO[]::new),
                mapArray(entity.getAgreement(), AgreementRefMapper::toDto, AgreementRefDTO[]::new),
                mapArray(entity.getCharacteristic(), CharacteristicMapper::toDto, CharacteristicDTO[]::new),
                mapArray(entity.getContactMedium(), ContactMediumMapper::toDto, ContactMediumDTO[]::new),
                mapArray(entity.getCreditProfile(), CreditProfileMapper::toDto, CreditProfileDTO[]::new),
                mapArray(entity.getPaymentMethod(), PaymentMethodRefMapper::toDto, PaymentMethodRefDTO[]::new),
                mapArray(entity.getRelatedParty(), RelatedPartyOrPartyRoleRefMapper::toDto, RelatedPartyOrPartyRoleRefDTO[]::new)
        );
    }

    private static <T, R> R[] mapArray(T[] source, Function<T, R> mapper, IntFunction<R[]> arrayGenerator) {
        if (source == null) {
            return null;
        }
        return Arrays.stream(source)
                .map(mapper)
                .toArray(arrayGenerator);
    }

    public record MappedCustomerArrays(
            AccountRef[] account,
            AgreementRef[] agreement,
            Characteristic[] characteristic,
            ContactMedium[] contactMedium,
            CreditProfile[] creditProfile,
            PaymentMethodRef[] paymentMethod,
            RelatedPartyOrPartyRoleRef[] relatedParty
    ) {}

    public record MappedCustomerDtoArrays(
            AccountRefDTO[] account,
            AgreementRefDTO[] agreement,
            CharacteristicDTO[] characteristic,
            ContactMediumDTO[] contactMedium,
            CreditProfileDTO[] creditProfile,
            PaymentMethodRefDTO[] paymentMethod,
            RelatedPartyOrPartyRoleRefDTO[] relatedParty
    ) {}
}
