package com.example.tmf629.model.account_ref;

import com.example.tmf629.enums.AccountType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountRef {
    private String id;
    private String name;
    private String baseType;
    private AccountType referredType;
    private String type;
}

