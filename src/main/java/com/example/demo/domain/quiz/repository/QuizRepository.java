package com.example.demo.domain.quiz.repository;

import com.example.demo.domain.quiz.Quiz;
import com.example.demo.domain.rank.Rank;
import com.example.demo.presentation.quiz.dto.response.QuizResponse;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @Query("SELECT q FROM Quiz q WHERE q.rank = :rank")
    List<Quiz> findByRank(@Param("rank") Rank rank);

    @Query("SELECT q.id FROM Quiz q")
    List<Long> findAllIds();
}
