package com.example.tmf629.model.party;

import com.example.tmf629.model.enums.PartyRoleSpecificationType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartyRoleSpecificationRef {
    // href, schemaLocation
    private String id;
    private String name;

    @Builder.Default
    private String baseType = "PartyRoleSpecificationRef";

    private PartyRoleSpecificationType referredType;

    @Builder.Default
    private String type = "PartyRoleSpecificationRef";
}
