package com.example.demo.presentation.auth.dto.request;


public record SignupRequest (

        String username,

        String accountId,

        String password
){}
