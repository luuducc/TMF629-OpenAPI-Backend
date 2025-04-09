package com.example.tmf629.dto;

public class CreateUserDTO {
    private String name;
    private String email;
    private String password;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public CreateUserDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

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
