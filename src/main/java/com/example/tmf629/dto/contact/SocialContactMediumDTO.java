package com.example.tmf629.dto.contact;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=true)
@JsonTypeName("SocialContactMedium")
@SuperBuilder
@NoArgsConstructor
public class SocialContactMediumDTO extends ContactMediumDTO {
    @Pattern(
            regexp = "^[A-Za-z0-9._-]{3,30}$",
            message = "Invalid social network ID: must be 3-30 characters, and can contain letters, numbers, dot, underscore, or hyphen"
    )
    private String socialNetworkId;
}
