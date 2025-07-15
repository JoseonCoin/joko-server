package com.example.demo.service.rank;

import com.example.demo.domain.rank.Job;
import com.example.demo.domain.rank.Rank;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankService {
    private final UserRepository userRepository;

    @Transactional
    public List<Job> getAvailableJobsForNextRank(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Rank nextRank = getNextRank(user.getRank());
        if (nextRank == null) throw new IllegalStateException("이미 최고 신분입니다.");
        return Job.getJobsByRank(nextRank);
    }

    @Transactional
    public void promoteRank(Long userId, Job selectedJob) {
        User user = userRepository.findById(userId).orElseThrow();
        Rank nextRank = getNextRank(user.getRank());
        if (nextRank == null) throw new IllegalStateException("이미 최고 신분입니다.");
        if (selectedJob.getRank() != nextRank) throw new IllegalArgumentException("선택한 직업이 신분에 맞지 않습니다.");
        int requiredCoin = nextRank.getRequiredCoin();
        user.spendCoin(requiredCoin);
        user.promoteRankAndJob(nextRank, selectedJob);
    }

    private Rank getNextRank(Rank current) {
        switch (current) {
            case CHEONMIN: return Rank.SANGMIN;
            case SANGMIN: return Rank.JUNGIN;
            case JUNGIN: return Rank.YANGBAN;
            case YANGBAN: return Rank.KING;
            case KING: return null;
            default: return null;
        }
    }
}
