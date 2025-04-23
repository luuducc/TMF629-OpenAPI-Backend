package com.example.tmf629.dto.contact;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=true)
@JsonTypeName("FaxContactMedium")
@SuperBuilder
@NoArgsConstructor
public class FaxContactMediumDTO extends ContactMediumDTO {
    @Pattern(regexp = "^\\+?[0-9\\-\\s]{7,20}$", message = "Invalid fax number format")
    private String faxNumber;
}
