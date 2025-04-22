package com.example.tmf629.model.party;

import com.example.tmf629.model.enums.PartyType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartyRef {
    // href, schemaLocation
    private String id;
    private String name;

    @Builder.Default
    private String baseType = "PartyRef";

    private PartyType referredType;

    @Builder.Default
    private String type = "PartyRef";
}
