package com.example.tmf629.model.account_ref;

import com.example.tmf629.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountRef {
    private String id;
    private String name;

    @JsonProperty("@baseType")
    private String baseType;

    @JsonProperty("@referredType")
    private AccountType referredType;

    @JsonProperty("@type")
    private String type;
}

