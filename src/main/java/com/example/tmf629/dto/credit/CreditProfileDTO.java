package com.example.tmf629.dto.credit;

import com.example.tmf629.model.time.TimePeriod;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditProfileDTO {
    private Instant creditProfileDate;

    private int creditRiskRating;
    private int creditScore;

    @Valid
    private TimePeriod validFor;
    private String href;

    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
