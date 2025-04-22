package com.example.tmf629.model.agreement;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AgreementRef {
    // href, schemaLocation
    private String id;
    private String name;

    @Builder.Default
    private String baseType = "AgreementRef";

    private String referredType;

    @Builder.Default
    private String type = "AgreementRef";
}
