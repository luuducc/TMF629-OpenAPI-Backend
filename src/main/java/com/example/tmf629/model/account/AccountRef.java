package com.example.tmf629.model.account;

import com.example.tmf629.model.enums.AccountType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountRef {
    // href, schemaLocation
    private String id;
    private String name;

    @Builder.Default
    private String baseType = "AccountRef";

    private AccountType referredType;

    @Builder.Default
    private String type = "AccountRef";
}

