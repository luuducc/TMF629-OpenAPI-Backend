package com.example.tmf629.exception;

public class DuplicateNameException extends RuntimeException {
    public DuplicateNameException(String name) {
        super("Duplicate name found: " + name);
    }
}
