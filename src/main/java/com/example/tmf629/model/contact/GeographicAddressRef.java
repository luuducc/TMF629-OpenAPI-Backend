package com.example.tmf629.model.contact;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeographicAddressRef {
    // href, schemaLocation
    private String id;
    private String name;
    private String baseType;
    private String referredType;
    private String type;
}
