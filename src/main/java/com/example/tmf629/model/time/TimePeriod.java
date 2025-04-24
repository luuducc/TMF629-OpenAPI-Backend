package com.example.tmf629.model.time;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TimePeriod {
    @NotBlank(message = "Field 'startDateTime' is required")
    private String startDateTime;

    @NotBlank(message = "Field 'endDateTime' is required")
    private String endDateTime;
}
