package com.example.tmf629.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDTO {
    private final String name;
    private final String email;

    public UserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // basic validation
    @JsonIgnore // to remove the validEmail key from response
    public boolean isValidEmail() {
        return email != null && email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

}
