package com.example.tmf629.dto.party;

import com.example.tmf629.dto.account.AccountRefDTO;
import com.example.tmf629.dto.agreement.AgreementRefDTO;
import com.example.tmf629.dto.characteristic.CharacteristicDTO;
import com.example.tmf629.dto.contact.ContactMediumDTO;
import com.example.tmf629.dto.credit.CreditProfileDTO;
import com.example.tmf629.model.enums.StatusType;
import com.example.tmf629.model.enums.PartyRoleType;
import com.example.tmf629.model.payment.PaymentMethodRef;
import com.example.tmf629.model.time.TimePeriod;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "@type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CustomerDTO.class, name = "Customer")
})
@Data
@SuperBuilder
@NoArgsConstructor
public class PartyRoleDTO {
    @Valid
    private AccountRefDTO[] account;

    private AgreementRefDTO[] agreement;
    private CharacteristicDTO[] characteristic;

    @Valid
    private ContactMediumDTO[] contactMedium;

    private CreditProfileDTO[] creditProfile;
    private String description;

    @NotNull(message = "Field 'engagedParty' is required")
    @Valid // Cascades validation to nested object
    private PartyRefDTO engagedParty;

    private String href;
    private String id;

    @NotBlank(message = "Field 'name' is required")
    private String name;

    private PartyRoleSpecificationRefDTO partyRoleSpecification;
    private PaymentMethodRef[] paymentMethod;
    private RelatedPartyOrPartyRoleRefDTO[] relatedParty;
    private String role;

    private StatusType status;
    private String statusReason;
    private TimePeriod validFor;

    @JsonProperty("@baseType")
    private String baseType;

    @JsonProperty("@schemaLocation")
    private String schemaLocation;

    @JsonProperty("@type")
    @NotNull(message = "Field '@type' is required")
    private PartyRoleType type;
}
