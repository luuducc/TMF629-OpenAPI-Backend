package com.example.tmf629.model.contact;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class GeographicAddressContactMedium extends ContactMedium {
    private String city;
    private String country;
    private GeographicAddressRef geographicAddress;
    private String postCode;
    private String stateOrProvince;
    // main address line - e.g. house number + street name ("123 Lê Lợi st")
    private String street1;
    // optional additional info - e.g. apartment, suite, building ("Apt. 302, Block B")
    private String street2;
}
