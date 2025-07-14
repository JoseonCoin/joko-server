package com.example.demo.presentation.auth.dto.request;

import lombok.Getter;

@Getter
public class LoginRequest {

    private String accountId;
    private String password;
}
