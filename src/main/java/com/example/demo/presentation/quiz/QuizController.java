package com.example.demo.presentation.quiz;

import com.example.demo.domain.quiz.Quiz;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.repository.UserRepository;
import com.example.demo.presentation.quiz.dto.request.QuizSubmitRequest;
import com.example.demo.presentation.quiz.dto.response.QuizResponse;
import com.example.demo.presentation.quiz.dto.response.QuizResultResponse;
import com.example.demo.service.quiz.QuizRetrievalService;
import com.example.demo.service.quiz.QuizSubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {
    private final QuizSubmissionService quizSubmissionService;
    private final QuizRetrievalService quizRetrievalService;
    private final UserRepository userRepository;

    @PostMapping("/submit")
    public QuizResultResponse submitQuiz(@RequestParam Long id, @RequestBody QuizSubmitRequest request) {
        return quizSubmissionService.submitQuiz(id, request);
    }

    @GetMapping("/ids")
    public List<Long> getQuizIds() {
        List<Long> quizIds = quizRetrievalService.getAllQuizIds();
        return quizIds;
    }

    @GetMapping("/{quizId}")
    public QuizResponse getQuiz(@PathVariable Long quizId) {
        return quizRetrievalService.getQuizById(quizId);
    }

    @GetMapping("/random")
    public QuizResponse getRandomQuiz(@AuthenticationPrincipal UserDetails userDetails) {
        String accountId = userDetails.getUsername();
        User user = userRepository.findByAccountId(accountId)
                .orElseThrow(() -> new UsernameNotFoundException(accountId));
        return quizRetrievalService.getRandomQuizByUserId(user.getId());
    }
}
