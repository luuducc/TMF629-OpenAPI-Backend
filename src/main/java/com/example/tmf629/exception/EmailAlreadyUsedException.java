package com.example.tmf629.exception;

    public class EmailAlreadyUsedException extends RuntimeException {
        public EmailAlreadyUsedException(String message) {
            super(message);
        }
    }
