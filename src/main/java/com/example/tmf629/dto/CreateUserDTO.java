package com.example.tmf629.dto;

public record CreateUserDTO(String name, String email, String password) {

    // basic validation
    private boolean isValidEmail() {
        return email != null && email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    private boolean isValidPassword() {
        return password != null && password.length() >= 8;
    }

    public boolean isValid() {
        return isValidEmail() && isValidPassword();
    }
}
