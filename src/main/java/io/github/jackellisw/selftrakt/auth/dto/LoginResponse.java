package io.github.jackellisw.selftrakt.auth.dto;

import lombok.Data;

@Data
public class LoginResponse {
    // access token
    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }

}
