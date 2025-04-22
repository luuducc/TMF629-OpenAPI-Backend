package com.example.tmf629.dto.party;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartyRoleSpecificationRefDTO {
    private String id;
    private String name;

    @JsonProperty("@baseType")
    private String baseType;

    @JsonProperty("@referredType")
    private String referredType;

    @JsonProperty("@type")
    private String type;

    private String href;

    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
