package com.vinimanfrin.autentication.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserAuthenticationDTO(
        @Email String email,
        @NotBlank String password
) {
}
