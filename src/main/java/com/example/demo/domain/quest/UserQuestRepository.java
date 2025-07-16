package com.example.demo.domain.quest;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserQuestRepository extends JpaRepository<UserQuest, Long> {
    List<UserQuest> findByUserId(Long userId);
} 