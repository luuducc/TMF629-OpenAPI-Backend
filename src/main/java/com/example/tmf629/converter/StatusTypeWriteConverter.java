package com.example.tmf629.converter;

import com.example.tmf629.model.enums.StatusType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StatusTypeWriteConverter implements Converter<StatusType, Integer> {
    @Override
    public Integer convert(StatusType source) {
        return source.getCode();
    }
}
