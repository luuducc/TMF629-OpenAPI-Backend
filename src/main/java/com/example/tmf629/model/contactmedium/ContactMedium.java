package com.example.tmf629.model.contactmedium;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "@type",
        visible = true // show the property for deserialization
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PhoneContactMedium.class, name = "PhoneContactMedium"),
        @JsonSubTypes.Type(value = GeographicAddressContactMedium.class, name = "GeographicAddressContactMedium")
})
@JsonInclude(JsonInclude.Include.NON_NULL) // Excludes null fields
@JsonPropertyOrder({
        "@type", "preferred", "contactType", "validFor"
})
@Data
public class ContactMedium {
    private String contactType;
    private String id;
    private boolean preferred;
    private TimePeriod validFor;

    @JsonProperty("@baseType")
    private String baseType;

    @JsonProperty("@schemaLocation")
    private String schemaLocation;

    @JsonProperty("@type")
    private String type;
}
