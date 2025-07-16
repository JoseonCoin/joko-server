package com.example.demo.service.quest;

import com.example.demo.domain.quest.UserQuestRepository;
import com.example.demo.presentation.quest.dto.UserQuestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.domain.quest.Quest;
import com.example.demo.domain.quest.QuestRepository;
import com.example.demo.domain.quest.QuestType;
import com.example.demo.domain.quest.UserQuest;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class QuestService {
    private final UserQuestRepository userQuestRepository;
    private final QuestRepository questRepository;
    private final UserRepository userRepository;

    public List<UserQuestResponse> getUserQuests(Long userId) {
        initDefaultQuestsForUser(userId);
        return userQuestRepository.findByUserId(userId).stream()
            .map(q -> new UserQuestResponse(
                q.getQuest().getId(),
                q.getQuest().getName(),
                q.getProgress(),
                q.getQuest().getGoal(),
                q.isCompleted()
            ))
            .collect(Collectors.toList());
    }

    private void initDefaultQuestsForUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        // 연속 출석 3회
        Quest attendanceQuest = questRepository.findAll().stream()
            .filter(q -> q.getType() == QuestType.CONTINUOUS_ATTENDANCE && q.getGoal() == 3)
            .findFirst()
            .orElseGet(() -> questRepository.save(Quest.builder()
                .name("연속 출석 3회")
                .type(QuestType.CONTINUOUS_ATTENDANCE)
                .goal(3)
                .reward(10)
                .build()));
        // 문제 5개 연속 정답
        Quest correctQuest = questRepository.findAll().stream()
            .filter(q -> q.getType() == QuestType.CONTINUOUS_CORRECT && q.getGoal() == 5)
            .findFirst()
            .orElseGet(() -> questRepository.save(Quest.builder()
                .name("문제 5개 연속 정답")
                .type(QuestType.CONTINUOUS_CORRECT)
                .goal(5)
                .reward(20)
                .build()));
        // 유저별 퀘스트 없으면 생성
        if (userQuestRepository.findByUserId(userId).stream().noneMatch(uq -> uq.getQuest().getId().equals(attendanceQuest.getId()))) {
            userQuestRepository.save(UserQuest.builder().user(user).quest(attendanceQuest).progress(0).completed(false).build());
        }
        if (userQuestRepository.findByUserId(userId).stream().noneMatch(uq -> uq.getQuest().getId().equals(correctQuest.getId()))) {
            userQuestRepository.save(UserQuest.builder().user(user).quest(correctQuest).progress(0).completed(false).build());
        }
    }

    @Transactional
    public boolean progressQuest(Long userId, QuestType type) {
        List<UserQuest> quests = userQuestRepository.findByUserId(userId).stream()
            .filter(q -> q.getQuest().getType() == type && !q.isCompleted())
            .collect(Collectors.toList());
        boolean anyCompleted = false;
        for (UserQuest uq : quests) {
            uq.setProgress(uq.getProgress() + 1);
            if (uq.getProgress() >= uq.getQuest().getGoal()) {
                uq.setCompleted(true);
                // 리워드 지급
                User user = uq.getUser();
                user.earnCoin(uq.getQuest().getReward());
                anyCompleted = true;
            }
            userQuestRepository.save(uq);
        }
        return anyCompleted; // true면 알림 필요
    }
}
