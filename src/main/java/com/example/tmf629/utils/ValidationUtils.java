package com.example.tmf629.utils;

import com.example.tmf629.exception.InvalidInputException;

public class ValidationUtils {
    private static final String OBJECT_ID_REGEX = "^[a-fA-F0-9]{24}$";

    public static void checkID(String id) {
        if (id == null || !id.matches(OBJECT_ID_REGEX)) {
            throw new IllegalArgumentException("ID " + id + " is not a valid ID");
        }
    }

    public static void requireNotBlank(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new InvalidInputException("Field '" + fieldName + "' is required");
        }
    }

    public static void requireNotNull(Object value, String fieldName) {
        if (value == null) {
            throw new InvalidInputException("Field '" + fieldName + "' is required");
        }
    }
}
