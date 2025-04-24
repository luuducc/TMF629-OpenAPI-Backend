package com.example.tmf629.dto.party;

import com.example.tmf629.dto.account.AccountRefDTO;
import com.example.tmf629.dto.agreement.AgreementRefDTO;
import com.example.tmf629.dto.characteristic.CharacteristicDTO;
import com.example.tmf629.dto.contact.ContactMediumDTO;
import com.example.tmf629.dto.credit.CreditProfileDTO;
import com.example.tmf629.dto.payment.PaymentMethodRefDTO;
import com.example.tmf629.model.enums.StatusType;
import com.example.tmf629.model.time.TimePeriod;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PatchCustomerDTO {
    @Valid // Cascades validation to nested object
    private AccountRefDTO[] account;

    private AgreementRefDTO[] agreement;
    private CharacteristicDTO[] characteristic;

    @Valid
    private ContactMediumDTO[] contactMedium;

    @Valid
    private CreditProfileDTO[] creditProfile;
    private String description;
    private PartyRefDTO engagedParty;
    private String name;
    private PartyRoleSpecificationRefDTO partyRoleSpecification;
    private PaymentMethodRefDTO[] paymentMethod;
    private RelatedPartyOrPartyRoleRefDTO[] relatedParty;
    private String role;
    private StatusType status;
    private String statusReason;

    @Valid
    private TimePeriod validFor;
}
