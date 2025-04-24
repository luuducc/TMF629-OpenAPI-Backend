package com.example.tmf629.exception;

import com.example.tmf629.dto.error.TmfErrorResponse;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmailAlreadyUsedException.class)
    public ResponseEntity<TmfErrorResponse> handleEmailAlreadyUsed(EmailAlreadyUsedException ex) {
        TmfErrorResponse response = TmfErrorResponse.builder()
                .type("ConflictError")
                .code("409")
                .reason("Email already in use")
                .schemaLocation("https://example.com/error-schema")
                .message(ex.getMessage())
                .status("409")
                .referenceError("https://example.com/errors/not-found")
                .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(IDNotFoundException.class)
    public ResponseEntity<TmfErrorResponse> handleIDNotFound(IDNotFoundException ex) {
        TmfErrorResponse response = TmfErrorResponse.builder()
                .type("NotFoundError")
                .code("404")
                .reason("The requested resource was not found")
                .schemaLocation("https://example.com/error-schema")
                .message(ex.getMessage())
                .status("404")
                .referenceError("https://example.com/errors/not-found")
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<TmfErrorResponse> handleInvalidInput(InvalidInputException ex) {
        TmfErrorResponse response = TmfErrorResponse.builder()
                .type("ValidationError")
                .code("400")
                .reason("Invalid input provided")
                .schemaLocation("https://example.com/error-schema")
                .message(ex.getMessage())
                .status("400")
                .referenceError("https://example.com/errors/bad-request")
                .build();
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<TmfErrorResponse> handleIllegalArgument(IllegalArgumentException ex) {
        TmfErrorResponse response = TmfErrorResponse.builder()
                .type("ValidationError")
                .code("400")
                .reason("Illegal argument provided")
                .schemaLocation("https://example.com/error-schema")
                .message(ex.getMessage())
                .status("400")
                .referenceError("https://example.com/errors/bad-request")
                .build();
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(InvalidTypeIdException.class)
    public ResponseEntity<TmfErrorResponse> handleInvalidTypeIdException(InvalidTypeIdException ex) {
        TmfErrorResponse response = TmfErrorResponse.builder()
                .type("ValidationError")
                .code("400")
                .reason("Invalid type specified in @type field")
                .schemaLocation("https://example.com/error-schema")
                .message(ex.getMessage())
                .status("400")
                .referenceError("https://example.com/errors/invalid-type")
                .build();
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<TmfErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldErrors().get(0);
        String field = fieldError.getField();
        String message = fieldError.getDefaultMessage();

        TmfErrorResponse response = TmfErrorResponse.builder()
                .type("ValidationError")
                .code("400")
                .reason("Invalid input provided")
                .schemaLocation("https://example.com/error-schema")
                .message(String.format("Field '%s': %s", field, message))
                .status("400")
                .referenceError("https://example.com/errors/bad-request")
                .build();
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<TmfErrorResponse> handleInvalidFormatException(InvalidFormatException ex) {
        String fieldName = ex.getPath().stream()
                .map(JsonMappingException.Reference::getFieldName)
                .filter(Objects::nonNull)
                .collect(Collectors.joining("."));
        Class<?> targetType = ex.getTargetType();
        String invalidValue = ex.getValue().toString();

        String message;

        if (targetType.isEnum()) {
            Object[] constants = targetType.getEnumConstants();
            String validValues = Arrays.stream(constants)
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            message = String.format("Invalid value '%s' for field '%s'. Allowed values: %s",
                    invalidValue, fieldName, validValues);
        } else if (targetType == LocalDateTime.class || targetType == LocalDate.class) {
            message = String.format("Invalid date format for field '%s'. Expected format: %s",
                    fieldName, targetType.getSimpleName());
        } else {
            message = String.format("Invalid value '%s' for field '%s'. Expected type: %s",
                    invalidValue, fieldName, targetType.getSimpleName());
        }

        TmfErrorResponse response = TmfErrorResponse.builder()
                .type("ValidationError")
                .code("400")
                .reason("Invalid input provided")
                .schemaLocation("https://example.com/error-schema")
                .message(message)
                .status("400")
                .referenceError("https://example.com/errors/bad-request")
                .build();
        return ResponseEntity.badRequest().body(response);
    }
}
