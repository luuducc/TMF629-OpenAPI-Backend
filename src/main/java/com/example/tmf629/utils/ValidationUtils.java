package com.example.tmf629.utils;

public class ValidationUtils {
    public static void checkRequired(String fieldValue, String fieldName) {
        if (fieldValue == null || fieldValue.isEmpty()) {
            throw new IllegalArgumentException("Field " + fieldName + " is required");
        }
    }
}
