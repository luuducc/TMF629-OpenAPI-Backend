package com.example.tmf629.dto.account;

import com.example.tmf629.model.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class AccountRefDTO {
    private String id;
    private String name;

    @JsonProperty("@baseType")
    private String baseType;

    @JsonProperty("@referredType")
    @NotNull(message = "Field 'AccountRef.@referredType' is required")
    private AccountType referredType;

    @JsonProperty("@type")
    private String type;

    private String href;

    @JsonProperty("@schemaLocation")
    private String schemaLocation;
}

