package com.example.tmf629.model.characteristic;

import com.example.tmf629.model.enums.RelationshipType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CharacteristicRelationship {
    // schemaLocation
    private String id;
    private RelationshipType relationshipType;

    @Builder.Default
    private String baseType = "CharacteristicRelationship";

    @Builder.Default
    private String type = "CharacteristicRelationship";
}
