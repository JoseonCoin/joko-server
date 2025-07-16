package com.example.demo.service.quiz;

import com.example.demo.domain.quiz.Quiz;
import com.example.demo.domain.quiz.repository.QuizRepository;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.repository.UserRepository;
import com.example.demo.presentation.quiz.dto.request.QuizSubmitRequest;
import com.example.demo.presentation.quiz.dto.response.QuizResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QuizSubmissionService {

    private final QuizRepository quizRepository;
    private final UserRepository userRepository;

    @Transactional
    public QuizResultResponse submitQuiz(Long userId, QuizSubmitRequest request){
        Quiz quiz = quizRepository.findById(request.getQuizId())
                .orElseThrow(() -> new IllegalArgumentException("퀴즈를 찾을 수 없습니다."));

        String selectedAnswer = switch (request.getSelectedIndex()) {
            case 0 -> quiz.getOption1();
            case 1 -> quiz.getOption2();
            case 2 -> quiz.getOption3();
            case 3 -> quiz.getOption4();
            default -> throw new IllegalArgumentException("선택지가 유효하지 않습니다.");
        };

        String correctAnswer = switch (quiz.getAnswerIndex()) {
            case 0 -> quiz.getOption1();
            case 1 -> quiz.getOption2();
            case 2 -> quiz.getOption3();
            case 3 -> quiz.getOption4();
            default -> throw new IllegalArgumentException("퀴즈에 정답이 설정되지 않았습니다.");
        };

        boolean correct = selectedAnswer.equals(correctAnswer);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));


        int coinReward = correct ? quiz.getCoin() : 0;

        if (correct) {
            user.addCoin(coinReward);
        }

        String explanation = quiz.getExplanation() != null ? quiz.getExplanation() : "해석이 제공되지 않습니다.";

        return new QuizResultResponse(correct, correctAnswer, explanation, coinReward);
    }
}
