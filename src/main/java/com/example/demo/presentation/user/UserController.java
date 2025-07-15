package com.example.demo.presentation.user;

import com.example.demo.domain.rank.Job;
import com.example.demo.presentation.user.dto.JobsResponse;
import com.example.demo.service.rank.RankService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final RankService rankService;

    @GetMapping("/jobs")
    public JobsResponse getNextJobs(@RequestParam Long userId) {
        List<Job> jobs = rankService.getAvailableJobsForNextRank(userId);
        String nextRank = jobs.isEmpty() ? null : jobs.get(0).getRank().name();
        return JobsResponse.of(nextRank, jobs);
    }

    @PostMapping("/promote")
    public void promote(@RequestParam Long userId, @RequestParam Job job) {
        rankService.promoteRank(userId, job);
    }
}
