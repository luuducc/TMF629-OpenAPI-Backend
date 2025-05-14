package com.example.tmf629.converter;
import com.example.tmf629.model.enums.StatusType;

import com.mongodb.lang.Nullable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StatusTypeReadConverter implements Converter<Integer, StatusType> {
    @Override
    public StatusType convert(@Nullable Integer source) {
        if (source == null) {
            return null;
        }
        for (StatusType status : StatusType.values()) {
            if (status.getCode() == source) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown code: " + source);
    }
}
