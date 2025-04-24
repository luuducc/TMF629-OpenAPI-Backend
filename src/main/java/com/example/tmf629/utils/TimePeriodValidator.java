package com.example.tmf629.utils;

import com.example.tmf629.model.time.TimePeriod;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TimePeriodValidator implements ConstraintValidator<ValidTimePeriod, TimePeriod> {
    @Override
    public boolean isValid(TimePeriod value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || value.getStartDateTime() == null || value.getEndDateTime() == null) {
            return true; // Let @NotNull handle null checks
        }
        return value.getEndDateTime().isAfter(value.getStartDateTime());
    }
}
