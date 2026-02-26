package io.github.jackellisw.selftrakt.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserRequest {
    @Email @NotBlank
    private String email;

    @NotBlank @Size(min = 8)
    private String password;

    public RegisterUserRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
