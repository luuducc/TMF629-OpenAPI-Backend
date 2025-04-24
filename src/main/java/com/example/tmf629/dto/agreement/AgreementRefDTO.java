package com.example.tmf629.dto.agreement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgreementRefDTO {
    private String id;
    private String name;

    private String baseType;

    private String referredType;

    private String type;

    private String href;

    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
