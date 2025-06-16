package com.example.tmf629.dto.contact;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=true)
@JsonTypeName("EmailContactMedium")
@SuperBuilder
@NoArgsConstructor
public class EmailContactMediumDTO extends ContactMediumDTO {
    @Email(message = "Invalid email address")
    @NotBlank(message = "Email field cannot be blank")
    private String emailAddress;
}
