package com.example.demo.domain.quiz;

import com.example.demo.domain.rank.Rank;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String question;

    private String option1;
    private String option2;

    private int answerIndex;

    private String correctAnswer;

    private int coin;
  
    private String imageUrl;

    @Column(nullable = false)
    private String explanation;

    @Column(name = "user_rank")
    @Enumerated(EnumType.STRING)
    private Rank rank;
}
