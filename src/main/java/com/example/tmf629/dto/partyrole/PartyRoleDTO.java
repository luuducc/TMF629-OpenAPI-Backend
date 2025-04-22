package com.example.tmf629.dto.partyrole;

import com.example.tmf629.dto.account.AccountRefDTO;
import com.example.tmf629.dto.partyref.PartyRefDTO;
import com.example.tmf629.dto.contact.ContactMediumDTO;
import com.example.tmf629.model.enums.CustomerStatus;
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
    @NotBlank(message = "Field 'name' is required")
    private String name;

    @JsonProperty("@type")
    @NotBlank(message = "Field '@type' is required")
    private String type;

    @JsonProperty("@baseType")
    private String baseType;

    @NotNull(message = "Field 'engagedParty' is required")
    @Valid // Cascades validation to nested object
    private PartyRefDTO engagedParty;

    private CustomerStatus status;
    private String id;
    private ContactMediumDTO[] contactMedium;
    private String href;

    @Valid
    private AccountRefDTO[] account;
}
