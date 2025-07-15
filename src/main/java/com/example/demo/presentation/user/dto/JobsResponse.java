package com.example.demo.presentation.user.dto;

import com.example.demo.domain.rank.Job;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class JobsResponse {
    private final String nextRank;
    private final List<String> jobs;

    public static JobsResponse of(String nextRank, List<Job> jobs) {
        return new JobsResponse(
                nextRank,
                jobs.stream().map(Job::name).toList()
        );
    }
}
