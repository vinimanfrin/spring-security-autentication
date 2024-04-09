package com.vinimanfrin.autentication.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDTO(
        @Email String email,
        @NotBlank String password,
        @NotNull UserRole role) {
}
