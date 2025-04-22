package com.example.tmf629.model.contact;

import com.example.tmf629.model.time.TimePeriod;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class ContactMedium {
    // schemaLocation
    private String contactType;
    private String id;
    private boolean preferred;
    private TimePeriod validFor;

    @Builder.Default
    private String baseType = "ContactMedium";

    @Builder.Default
    private String type = "ContactMedium";
}
