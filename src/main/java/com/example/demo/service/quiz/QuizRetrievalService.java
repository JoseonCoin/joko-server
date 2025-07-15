package com.example.demo.service.quiz;

import com.example.demo.domain.quiz.Quiz;
import com.example.demo.domain.quiz.repository.QuizRepository;
import com.example.demo.domain.rank.Rank;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.repository.UserRepository;
import com.example.demo.presentation.quiz.dto.response.QuizResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class QuizRetrievalService {

    private final QuizRepository quizRepository;
    private final UserRepository userRepository;

    private final Random random = new SecureRandom();

    public QuizResponse getQuizById(Long id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 퀴즈를 찾을 수 없습니다."));

        return new QuizResponse(
                quiz.getId(),
                quiz.getQuestion(),
                List.of(quiz.getOption1(), quiz.getOption2(), quiz.getOption3(), quiz.getOption4()),
                quiz.getImageUrl()
        );
    }

    public QuizResponse getRandomQuizByUserId(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        Rank rank = user.getRank();

        List<Quiz> quizzes = quizRepository.findByRank(rank);

        if (quizzes.isEmpty()) {
            throw new IllegalArgumentException("유저 신분에 맞는 퀴즈가 없습니다.");
        }

        int randomIndex = random.nextInt(quizzes.size());

        Quiz quiz = quizzes.get(randomIndex);

        return new QuizResponse(
                quiz.getId(),
                quiz.getQuestion(),
                List.of(quiz.getOption1(), quiz.getOption2(), quiz.getOption3(), quiz.getOption4()),
                quiz.getImageUrl()
        );
    }

    public List<Quiz> getQuizList() {

        return quizRepository.findAll();
    }
}
