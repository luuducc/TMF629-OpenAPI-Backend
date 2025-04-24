package com.example.tmf629.dto.credit;

import com.example.tmf629.model.time.TimePeriod;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditProfileDTO {
    private String creditProfileDate;
    private int creditRiskRating;
    private int creditScore;
    private TimePeriod validFor;
    private String href;

    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
