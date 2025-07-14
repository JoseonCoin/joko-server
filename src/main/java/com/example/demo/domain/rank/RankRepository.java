package com.example.demo.domain.rank;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RankRepository extends JpaRepository<Rank, Long> {
    // 추가적인 쿼리 메서드는 필요시 선언
} 