package com.example.demo.presentation.quiz.dto.request;

import lombok.Getter;

@Getter
public class QuizSubmitRequest {

    private Long quizId;
    private int selectedIndex;
}
