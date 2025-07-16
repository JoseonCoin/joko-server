package com.example.demo.presentation.auth.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignupRequest (

        @NotBlank(message = "사용자 이름은 필수입니다.")
        String username,

        @NotBlank(message = "accountId는 필수입니다.")
        String accountId,

        @NotBlank(message = "비밀번호는 필수입니다.")
        String password
){}
