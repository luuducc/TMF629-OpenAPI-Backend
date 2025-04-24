package com.example.tmf629.dto.party;

import com.example.tmf629.dto.account.AccountRefDTO;
import com.example.tmf629.dto.agreement.AgreementRefDTO;
import com.example.tmf629.dto.characteristic.CharacteristicDTO;
import com.example.tmf629.dto.contact.ContactMediumDTO;
import com.example.tmf629.dto.credit.CreditProfileDTO;
import com.example.tmf629.dto.payment.PaymentMethodRefDTO;
import com.example.tmf629.model.enums.StatusType;
import com.example.tmf629.model.enums.PartyRoleType;
import com.example.tmf629.model.time.TimePeriod;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartyRoleDTO {
    @Valid // Cascades validation to nested object
    private AccountRefDTO[] account;

    private AgreementRefDTO[] agreement;
    private CharacteristicDTO[] characteristic;

    @Valid
    private ContactMediumDTO[] contactMedium;

    @Valid
    private CreditProfileDTO[] creditProfile;

    private String description;

    @Valid
    private PartyRefDTO engagedParty;

    private String href;
    private String id;
    private String name;
    private PartyRoleSpecificationRefDTO partyRoleSpecification;
    private PaymentMethodRefDTO[] paymentMethod;
    private RelatedPartyOrPartyRoleRefDTO[] relatedParty;
    private String role;
    private StatusType status;
    private String statusReason;

    @Valid
    private TimePeriod validFor;

    @JsonProperty("@baseType")
    private String baseType;

    @JsonProperty("@schemaLocation")
    private String schemaLocation;

    @JsonProperty("@type")
    private PartyRoleType type;
}
