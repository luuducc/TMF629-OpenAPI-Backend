package com.example.tmf629.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusType {
    Draft(0)     ,     // secondary
    Created(1),        // info
    Pending(2),        // info
    Verified(3),       // success
    Active(4),         // success
    Suspended(5),      // warn
    Inactive(6),       // secondary
    Archived(7),       // secondary
    Blacklisted(8),    // danger
    Rejected(9),       // danger
    Deleted(10);
    private final int code;
    StatusType(int code) {
        this.code = code;
    }
    @JsonValue
    public int getCode() {
        return code;
    }
}