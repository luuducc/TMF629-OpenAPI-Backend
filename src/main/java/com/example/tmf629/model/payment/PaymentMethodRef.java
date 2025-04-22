package com.example.tmf629.model.payment;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentMethodRef {
    // href, schemaLocation
    private String id;
    private String name;

    @Builder.Default
    private String baseType = "PaymentMethodRef";

    private String referredType;

    @Builder.Default
    private String type = "PaymentMethodRef";
}
