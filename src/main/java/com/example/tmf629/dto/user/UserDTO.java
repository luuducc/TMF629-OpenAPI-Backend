package com.example.tmf629.dto.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record UserDTO(String id, String name, String email) {

    // basic validation
    @JsonIgnore // to remove the validEmail key from response
    public boolean isValidEmail() {
        return email != null && email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

}
