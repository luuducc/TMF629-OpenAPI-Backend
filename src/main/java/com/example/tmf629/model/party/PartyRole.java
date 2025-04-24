package com.example.tmf629.model.party;

import com.example.tmf629.model.agreement.AgreementRef;
import com.example.tmf629.model.characteristic.Characteristic;
import com.example.tmf629.model.credit.CreditProfile;
import com.example.tmf629.model.enums.StatusType;
import com.example.tmf629.model.account.AccountRef;
import com.example.tmf629.model.contact.ContactMedium;
import com.example.tmf629.model.enums.PartyRoleType;
import com.example.tmf629.model.payment.PaymentMethodRef;
import com.example.tmf629.model.time.TimePeriod;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

@Data
@SuperBuilder
@NoArgsConstructor
public class PartyRole {
    // href, schemaLocation
    private AccountRef[] account;
    private AgreementRef[] agreement;
    private Characteristic[] characteristic;
    private ContactMedium[] contactMedium;
    private CreditProfile[] creditProfile;
    private String description;
    private PartyRef engagedParty;

    @Id
    private String id;

    private String name;
    private PartyRoleSpecificationRef partyRoleSpecification;
    private PaymentMethodRef[] paymentMethod;
    private RelatedPartyOrPartyRoleRef[] relatedParty;
    private String role;
    private StatusType status;
    private String statusReason;
    private TimePeriod validFor;

    @Builder.Default
    private String baseType = "PartyRole";

    private PartyRoleType type;
}
