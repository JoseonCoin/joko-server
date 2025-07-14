package com.example.demo.domain.rank;

public enum Job {
    NOBI(Rank.CHEONMIN),         // 노비
    NONGMIN(Rank.SANGMIN),       // 농민
    SANGIN(Rank.SANGMIN),        // 상인
    SATTO(Rank.JUNGIN),         // 사또
    HYANGNI(Rank.JUNGIN),       // 향리
    JIJU(Rank.YANGBAN),          // 지주
    KING(Rank.KING);             // 왕

    private final Rank rank;

    Job(Rank rank) {
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }
}
