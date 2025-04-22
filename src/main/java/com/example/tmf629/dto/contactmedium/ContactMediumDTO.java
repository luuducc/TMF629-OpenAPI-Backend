package com.example.tmf629.dto.contactmedium;

import com.example.tmf629.model.time.TimePeriod;
import com.fasterxml.jackson.annotation.*;
import lombok.Builder;
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
        @JsonSubTypes.Type(value = PhoneContactMediumDTO.class, name = "PhoneContactMedium"),
        @JsonSubTypes.Type(value = GeographicAddressContactMediumDTO.class, name = "GeographicAddressContactMedium")
})
@JsonInclude(JsonInclude.Include.NON_NULL) // Excludes null fields
@Data
@SuperBuilder
@NoArgsConstructor
public class ContactMediumDTO {
    private String contactType;
    private String id;
    private boolean preferred;
    private TimePeriod validFor;

    @JsonProperty("@baseType")
    @Builder.Default
    private String baseType = "ContactMedium";

    @JsonProperty("@schemaLocation")
    private String schemaLocation;

    @JsonProperty("@type")
    private String type;
}
