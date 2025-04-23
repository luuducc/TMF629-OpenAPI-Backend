package com.example.tmf629.dto.characteristic;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CharacteristicDTO {
    // schemaLocation
    private CharacteristicRelationshipDTO characteristicRelationship;
    private String id;
    private String name;
    private String valueType;

    @JsonProperty("@baseType")
    private String baseType;

    @JsonProperty("@type")
    private String type;

    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
