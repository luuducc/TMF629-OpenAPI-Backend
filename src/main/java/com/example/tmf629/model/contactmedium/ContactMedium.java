package com.example.tmf629.model.contactmedium;

import com.example.tmf629.common.TimePeriod;
import com.fasterxml.jackson.annotation.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class ContactMedium {
    private String contactType;
    private String id;
    private boolean preferred;
    private TimePeriod validFor;

    @JsonProperty("@baseType")
    @Builder.Default
    private String baseType = "ContactMedium";

    @JsonProperty("@schemaLocation")
    private String schemaLocation;

    @JsonProperty("@type")
    private String type;
}
