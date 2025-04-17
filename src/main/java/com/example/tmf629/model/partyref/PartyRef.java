package com.example.tmf629.model.partyref;

import com.example.tmf629.enums.PartyType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartyRef {
    private String id;
    private String name;
    private String baseType;
    private PartyType referredType;
    private String type;
}
