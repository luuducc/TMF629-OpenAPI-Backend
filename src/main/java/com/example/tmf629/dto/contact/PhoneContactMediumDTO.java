package com.example.tmf629.dto.contact;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=true)
@JsonTypeName("PhoneContactMedium")
@SuperBuilder
@NoArgsConstructor
public class PhoneContactMediumDTO extends ContactMediumDTO {
    private String phoneNumber;
}
