package com.example.tmf629.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TmfErrorResponse {
    @JsonProperty("@type")
    private String type;

    private String code;
    private String reason;
    private String message;
    private String status;
    private String referenceError;

    @JsonProperty("@baseType")
    @Builder.Default
    private String baseType = "ApiError";

    @JsonProperty("@schemaLocation")
    private String schemaLocation;

}
