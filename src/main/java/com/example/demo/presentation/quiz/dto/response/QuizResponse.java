package com.example.demo.presentation.quiz.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QuizResponse {

    private Long id;
    private String question;
    private List<String> options;
    private int coin;
    private String imageUrl;
}
