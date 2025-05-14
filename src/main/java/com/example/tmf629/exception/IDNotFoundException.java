package com.example.tmf629.exception;

public class IDNotFoundException extends RuntimeException {
    public IDNotFoundException(String id) {
        super("ID " + id + " not found");
    }
}
