package com.example.tmf629.utils;

import java.util.Map;

public class ValidationUtils {
    private static final String OBJECT_ID_REGEX = "^[a-fA-F0-9]{24}$";

    public static void checkID(String id) {
        if (id == null || !id.matches(OBJECT_ID_REGEX)) {
            throw new IllegalArgumentException("ID " + id + " is not a valid ID");
        }
    }
}
