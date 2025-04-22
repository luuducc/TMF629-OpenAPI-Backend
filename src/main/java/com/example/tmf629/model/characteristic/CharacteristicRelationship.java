package com.example.tmf629.model.characteristic;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CharacteristicRelationship {
    // schemaLocation
    private String id;
    private String relationshipType;

    @Builder.Default
    private String baseType = "CharacteristicRelationship";

    @Builder.Default
    private String type = "CharacteristicRelationship";
}
