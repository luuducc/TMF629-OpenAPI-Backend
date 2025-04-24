package com.example.tmf629.model.time;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TimePeriod {
    @NotNull(message = "Field 'startDateTime' is required")
    private LocalDateTime startDateTime;

    @NotNull(message = "Field 'endDateTime' is required")
    private LocalDateTime endDateTime;
}
