package com.example.tmf629.model.party;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RelatedPartyOrPartyRoleRef {
    // schemaLocation
    private PartyRef partyOrPartyRole;
    private String role;

    @Builder.Default
    private String baseType = "RelatedPartyOrPartyRoleRef";

    @Builder.Default
    private String type = "RelatedPartyOrPartyRoleRef";
}
