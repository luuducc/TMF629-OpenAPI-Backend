package com.example.tmf629.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ValueType {
    string("string"),
    number("number"),
    bool("boolean"),
    date("date"),
    object("object"),
    array("array");
    private final String value;
    ValueType(String value) {
        this.value = value;
    }
    @JsonValue
    public String getValue() {
        return value;
    }
}