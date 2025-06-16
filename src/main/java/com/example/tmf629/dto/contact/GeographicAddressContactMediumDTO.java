package com.example.tmf629.dto.contact;

import com.example.tmf629.model.contact.GeographicAddressRef;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Field country cannot be blank")
    private String country;
    private GeographicAddressRef geographicAddress;
    private String postCode;
    private String stateOrProvince;
    private String street1;
    private String street2;
}
