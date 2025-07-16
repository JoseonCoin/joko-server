package com.example.demo.presentation.quest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserQuestResponse {
    private final Long questId;
    private final String name;
    private final int progress;
    private final int goal;
    private final boolean completed;
}
