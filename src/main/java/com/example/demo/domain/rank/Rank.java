package com.example.demo.domain.rank;

public enum Rank {
    CHEONMIN(0),   // 천민
    SANGMIN(10),    // 상민
    JUNGIN(30),    // 중인
    YANGBAN(50),    // 양반
    KING(100);        // 왕

    private final int requiredCoin;

    Rank(int requiredCoin) {
        this.requiredCoin = requiredCoin;
    }

    public int getRequiredCoin() {
        return requiredCoin;
    }
}
