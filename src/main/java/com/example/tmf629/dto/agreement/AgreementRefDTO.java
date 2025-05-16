package com.example.tmf629.dto.agreement;

import com.example.tmf629.model.enums.AgreementType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgreementRefDTO {
    private String id;
    private String name;

    private String baseType;

    @JsonProperty("@referredType")
    @NotNull(message = "Field 'AgreementRef.@referredType' is required")
    private AgreementType referredType;

    private String type;

    private String href;

    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
