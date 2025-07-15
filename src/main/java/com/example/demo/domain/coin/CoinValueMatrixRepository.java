package com.example.demo.domain.coin;

import com.example.demo.domain.rank.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoinValueMatrixRepository extends JpaRepository<CoinValueMatrix, Long> {
    Optional<CoinValueMatrix> findByEraAndRank(Era era, Rank rank);
}
