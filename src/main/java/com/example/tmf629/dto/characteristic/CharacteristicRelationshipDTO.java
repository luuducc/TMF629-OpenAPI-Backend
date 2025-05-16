package com.example.tmf629.dto.characteristic;

import com.example.tmf629.model.enums.RelationshipType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CharacteristicRelationshipDTO {
    // schemaLocation
    private String id;
    private RelationshipType relationshipType;

    @JsonProperty("@baseType")
    private String baseType;

    @JsonProperty("@type")
    private String type;

    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
