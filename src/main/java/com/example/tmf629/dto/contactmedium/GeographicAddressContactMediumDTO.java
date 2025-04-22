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
    private String street1;
    private String street2;
}
