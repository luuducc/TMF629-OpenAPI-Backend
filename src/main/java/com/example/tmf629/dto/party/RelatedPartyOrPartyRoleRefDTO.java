package com.example.tmf629.dto.party;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RelatedPartyOrPartyRoleRefDTO {
    // schemaLocation
    private PartyRefDTO partyOrPartyRole;
    private String role;

    @JsonProperty("@baseType")
    private String baseType;

    @JsonProperty("@type")
    private String type;

    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
