package com.example.tmf629.model.characteristic;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Characteristic {
    // schemaLocation
    private CharacteristicRelationship characteristicRelationship;
    private String id;
    private String name;
    private String valueType;

    @Builder.Default
    private String baseType = "Characteristic";

    @Builder.Default
    private String type = "Characteristic";
}
