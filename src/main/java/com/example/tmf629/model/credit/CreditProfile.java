package com.example.tmf629.model.credit;

import com.example.tmf629.model.time.TimePeriod;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class CreditProfile {
    // href, schemaLocation
    private Instant creditProfileDate;
    private int creditRiskRating;
    private int creditScore;
    private TimePeriod validFor;
}
