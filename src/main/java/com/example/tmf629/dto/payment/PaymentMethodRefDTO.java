package com.example.tmf629.dto.payment;

import com.example.tmf629.model.enums.PaymentMethodType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentMethodRefDTO {
    private String id;
    private String name;

    @JsonProperty("@baseType")
    private String baseType;

    @JsonProperty("@referredType")
    private PaymentMethodType referredType;

    @JsonProperty("@type")
    private String type;

    private String href;

    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}
