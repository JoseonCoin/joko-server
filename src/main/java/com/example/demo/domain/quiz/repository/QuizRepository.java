package com.example.demo.domain.quiz.repository;

import com.example.demo.domain.quiz.Quiz;
import com.example.demo.domain.rank.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    List<Quiz> findByRank(Rank rank);
}
