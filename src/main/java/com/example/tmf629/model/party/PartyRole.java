package com.example.tmf629.model.party;

import com.example.tmf629.model.enums.CustomerStatus;
import com.example.tmf629.model.account.AccountRef;
import com.example.tmf629.model.contact.ContactMedium;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

@Data
@SuperBuilder
@NoArgsConstructor
public class PartyRole {
    private AccountRef[] account;
    private ContactMedium[] contactMedium;
    private PartyRef engagedParty;
    private String name;
    private String type;

    @Id
    private String id;

    private CustomerStatus status;

    @Builder.Default
    private String baseType = "PartyRef";

}
