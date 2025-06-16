package com.example.tmf629.dto.contact;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Field phone number cannot be blank")
    private String phoneNumber;
}
