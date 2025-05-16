package com.example.tmf629.model.agreement;

import com.example.tmf629.model.enums.AgreementType;
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

    private AgreementType referredType;

    @Builder.Default
    private String type = "AgreementRef";
}
