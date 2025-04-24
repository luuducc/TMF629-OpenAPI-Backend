package com.example.tmf629.model.credit;

import com.example.tmf629.model.time.TimePeriod;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CreditProfile {
    // href, schemaLocation
    private LocalDate creditProfileDate;
    private int creditRiskRating;
    private int creditScore;
    private TimePeriod validFor;
}
