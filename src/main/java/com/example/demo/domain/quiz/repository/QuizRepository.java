package com.example.demo.domain.quiz.repository;

import com.example.demo.domain.quiz.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Long> {
}
