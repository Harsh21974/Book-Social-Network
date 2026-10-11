package com.example.book_network.controller;

import com.example.book_network.dto.AuthResponse;
import com.example.book_network.dto.LoginRequestDTO;
import com.example.book_network.dto.RegisterRequestDTO;
import com.example.book_network.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> register( @Valid @RequestBody RegisterRequestDTO request) throws MessagingException {
        authService.register(request);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequestDTO request) throws MessagingException {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/activate-account")
    public void confirm( @RequestParam String token) throws MessagingException {
        authService.activateAccount(token);
    }
}