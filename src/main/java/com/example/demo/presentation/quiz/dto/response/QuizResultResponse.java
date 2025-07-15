package com.example.demo.presentation.quiz.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuizResultResponse {

    private boolean correct;
    private String explanation;
    private int coinReward;
}
