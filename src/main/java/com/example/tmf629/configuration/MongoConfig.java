package com.example.tmf629.configuration;

import com.example.tmf629.converter.StatusTypeReadConverter;
import com.example.tmf629.converter.StatusTypeWriteConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.List;

@Configuration
public class MongoConfig {
    @Bean
    public MongoCustomConversions customConversions() {
        return new MongoCustomConversions(
                List.of(
                        new StatusTypeReadConverter(),
                        new StatusTypeWriteConverter()
                )
        );
    }
}
