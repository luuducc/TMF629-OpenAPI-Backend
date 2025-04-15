package com.example.tmf629.model.partyref;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "@referredType",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Organization.class, name = "Organization")
})
@JsonInclude(JsonInclude.Include.NON_NULL) // Exclude null fields
@Data
public class PartyRef {
    private String href;
    private String id;
    @JsonProperty(required = true)
    private String name;

    @JsonProperty("@baseType")
    private String baseType;

    @JsonProperty("@referredType")
    private String referredType; // Individual or Organization

    @JsonProperty("@schemaLocation")
    private String schemaLocation;

    @JsonProperty("@type")
    private String type;
}
