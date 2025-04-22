package com.example.tmf629.dto.agreement;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AgreementRefDTO {
    private String id;
    private String name;

    @Builder.Default
    private String baseType = "AgreementRef";

    private String referredType;

    @Builder.Default
    private String type = "AgreementRef";

    private String href;

    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
