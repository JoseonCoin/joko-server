package com.example.demo.domain.quiz;

import com.example.demo.domain.quiz.type.Rank;
import com.example.demo.domain.quiz.type.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    private String option1;
    private String option2;
    private String option3;
    private String option4;

    private String answer;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Rank rank;
}
