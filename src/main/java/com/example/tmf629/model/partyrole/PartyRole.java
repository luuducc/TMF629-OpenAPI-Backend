package com.example.tmf629.model.partyrole;

import com.example.tmf629.enums.CustomerStatus;
import com.example.tmf629.model.accountref.AccountRef;
import com.example.tmf629.model.partyref.PartyRef;
import com.example.tmf629.model.contactmedium.ContactMedium;
import lombok.Builder;
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
    private String type;

    @Builder.Default
    private String baseType = "PartyRef";
    private PartyRef engagedParty;
    private CustomerStatus status;
    private ContactMedium[] contactMedium;
    private AccountRef[] account;
}
