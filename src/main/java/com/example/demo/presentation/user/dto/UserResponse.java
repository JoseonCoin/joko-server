package com.example.demo.presentation.user.dto;

import com.example.demo.domain.coin.Era;
import com.example.demo.domain.rank.Rank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponse {
    private final int coin;
    private final Era era;
    private final Rank rank;
}
