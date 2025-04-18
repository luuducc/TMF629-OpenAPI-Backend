package com.example.tmf629.dto.contactmedium;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=true)
@JsonTypeName("GeographicAddressContactMedium")
@SuperBuilder
@NoArgsConstructor
public class GeographicAddressContactMediumDTO extends ContactMediumDTO {
    private String city;
    private String country;
    private String postCode;
    private String stateOrProvince;
    // main address line - e.g. house number + street name ("123 Lê Lợi st")
    private String street1;
    // optional additional info - e.g. apartment, suite, building ("Apt. 302, Block B")
    private String street2;
}
