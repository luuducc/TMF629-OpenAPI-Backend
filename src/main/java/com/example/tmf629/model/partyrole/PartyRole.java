package com.example.tmf629.model.partyrole;

import com.example.tmf629.model.account_ref.AccountRef;
import com.example.tmf629.model.partyref.PartyRef;
import com.example.tmf629.model.contactmedium.ContactMedium;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

@Data
@SuperBuilder
@NoArgsConstructor
public class PartyRole {
    @Id
    private String id;
    private String name;

    @JsonProperty("@type")
    private String type;

    private PartyRef engagedParty;
    private String status;
    private ContactMedium[] contactMedium;
    private AccountRef[] account;
}
