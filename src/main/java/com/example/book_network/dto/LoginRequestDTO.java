package com.example.book_network.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginRequestDTO {

    @Email(message = "Invalid email address")
    @NotNull(message = "Email is required")
    @NotBlank(message = "Email is required")
    private String email;

    @NotNull(message = "Email is required")
    @NotBlank(message = "Email is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

}
