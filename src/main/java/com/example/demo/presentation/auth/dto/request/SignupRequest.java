package com.example.demo.presentation.auth.dto.request;

import com.example.demo.domain.rank.Rank;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public record SignupRequest (

        @NotBlank(message = "사용자 이름은 필수입니다.")
        @Max(8)
        String username,

        @NotBlank(message = "accountId는 필수입니다.")
        String accountId,

        @NotBlank(message = "비밀번호는 필수입니다.")
        @Size(min = 8, max = 255, message = "비밀번호는 8자 이상 입력해야 합니다.")
        String password,

        Rank rank
){}
