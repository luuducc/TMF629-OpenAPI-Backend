package com.example.tmf629.mapper.party;

import com.example.tmf629.dto.party.PatchCustomerDTO;
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

public class PatchCustomerMapper {
    public static Customer toEntity(PatchCustomerDTO dto) {
        if (dto == null) {
            return null;
        }

        AccountRef[] account = CustomerHelper.mapArray(dto.getAccount(), AccountRefMapper::toEntity, AccountRef[]::new);
        AgreementRef[] agreement = CustomerHelper.mapArray(dto.getAgreement(), AgreementRefMapper::toEntity, AgreementRef[]::new);
        Characteristic[] characteristic = CustomerHelper.mapArray(dto.getCharacteristic(), CharacteristicMapper::toEntity, Characteristic[]::new);
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
                .name(dto.getName())
                .partyRoleSpecification(PartyRoleSpecificationRefMapper.toEntity(dto.getPartyRoleSpecification()))
                .paymentMethod(paymentMethod)
                .relatedParty(relatedParty)
                .role(dto.getRole())
                .status(dto.getStatus())
                .statusReason(dto.getStatusReason())
                .validFor(dto.getValidFor())
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
