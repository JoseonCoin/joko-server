package com.example.demo.presentation.user.dto;

import com.example.demo.domain.coin.Era;
import com.example.demo.domain.rank.Job;
import com.example.demo.domain.rank.Rank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponse {
    private final Long userId;
    private final int coin;
    private final Era era;
    private final Job job;
    private final Rank rank;

    public UserResponse(int coin, Era era, Job job, Rank rank, Long userId) {
        this.userId = userId;
        this.coin = coin;
        this.era = era;
        this.job = job;
        this.rank = rank;
    }
    public UserResponse(int coin, Era era, Job job, Rank rank) {
        this(null, coin, era, job, rank);
    }
}
