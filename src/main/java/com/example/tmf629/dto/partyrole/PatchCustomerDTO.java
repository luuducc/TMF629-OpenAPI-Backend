package com.example.tmf629.dto.partyrole;

import com.example.tmf629.model.contact.ContactMedium;
import com.example.tmf629.model.party.PartyRef;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PatchCustomerDTO {
    private String name;
    private PartyRef engagedParty;
    private String status;
    private ContactMedium[] contactMedium;
}
