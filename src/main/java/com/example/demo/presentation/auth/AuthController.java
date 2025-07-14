package com.example.demo.presentation.auth;

import com.example.demo.presentation.auth.dto.request.LoginRequest;
import com.example.demo.presentation.auth.dto.request.SignupRequest;
import com.example.demo.presentation.auth.dto.response.TokenResponse;
import com.example.demo.service.auth.LoginService;
import com.example.demo.service.auth.SignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final SignupService signupService;
    private final LoginService loginService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody @Valid SignupRequest request) {
        signupService.signup(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.login(request);
    }
}
