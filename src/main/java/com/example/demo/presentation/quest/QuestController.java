package com.example.demo.presentation.quest;

import com.example.demo.presentation.quest.dto.UserQuestResponse;
import com.example.demo.service.quest.QuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/quest")
@RequiredArgsConstructor
public class QuestController {
    private final QuestService questService;

    @GetMapping("/list")
    public List<UserQuestResponse> getUserQuests(@RequestParam Long userId) {
        return questService.getUserQuests(userId);
    }
}
