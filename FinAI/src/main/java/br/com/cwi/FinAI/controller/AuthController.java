package br.com.cwi.FinAI.controller;

import br.com.cwi.FinAI.dto.request.LoginRequest;
import br.com.cwi.FinAI.dto.request.RegisterRequest;
import br.com.cwi.FinAI.dto.response.ApiResponse;
import br.com.cwi.FinAI.dto.response.CustomerResponse;
import br.com.cwi.FinAI.dto.response.LoginResponse;
import br.com.cwi.FinAI.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(
            @Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(ApiResponse.ok(authService.authenticate(request)));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<CustomerResponse> register(
            @Valid @RequestBody RegisterRequest request) {
        return ApiResponse.ok(authService.register(request));
    }
}
