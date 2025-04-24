package com.example.tmf629.dto.contact;

import com.example.tmf629.model.enums.ContactMediumType;
import com.example.tmf629.model.time.TimePeriod;
import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "@type",
        visible = true // show the property for deserialization
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = EmailContactMediumDTO.class, name = "EmailContactMedium"),
        @JsonSubTypes.Type(value = FaxContactMediumDTO.class, name = "FaxContactMedium"),
        @JsonSubTypes.Type(value = GeographicAddressContactMediumDTO.class, name = "GeographicAddressContactMedium"),
        @JsonSubTypes.Type(value = PhoneContactMediumDTO.class, name = "PhoneContactMedium"),
        @JsonSubTypes.Type(value = SocialContactMediumDTO.class, name = "SocialContactMedium"),
})
@JsonInclude(JsonInclude.Include.NON_NULL) // Excludes null fields
@Data
@SuperBuilder
@NoArgsConstructor
public class ContactMediumDTO {
    private String contactType;
    private String id;
    private boolean preferred;

    @Valid
    private TimePeriod validFor;

    @JsonProperty("@baseType")
    private String baseType;

    @JsonProperty("@type")
    private ContactMediumType type;

    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
