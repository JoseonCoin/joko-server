package com.example.demo.domain.rank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<Job> getJobsByRank(Rank rank) {
        return Arrays.stream(Job.values())
                .filter(job -> job.getRank() == rank)
                .collect(Collectors.toList());
    }
}
