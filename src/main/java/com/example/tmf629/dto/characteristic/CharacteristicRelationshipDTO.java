package com.example.tmf629.dto.characteristic;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CharacteristicRelationshipDTO {
    // schemaLocation
    private String id;
    private String relationshipType;

    @JsonProperty("@baseType")
    private String baseType;

    @JsonProperty("@type")
    private String type;

    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
