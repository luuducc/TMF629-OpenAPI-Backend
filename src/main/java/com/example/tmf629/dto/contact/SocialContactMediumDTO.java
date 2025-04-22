package com.example.tmf629.dto.contact;

import com.fasterxml.jackson.annotation.JsonTypeName;
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
    private String socialNetworkId;
}
