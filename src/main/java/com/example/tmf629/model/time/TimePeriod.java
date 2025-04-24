package com.example.tmf629.model.time;

import com.example.tmf629.utils.ValidTimePeriod;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ValidTimePeriod
public class TimePeriod {
    @NotNull(message = "Field 'startDateTime' is required")
    private LocalDateTime startDateTime;

    @NotNull(message = "Field 'endDateTime' is required")
    private LocalDateTime endDateTime;
}
