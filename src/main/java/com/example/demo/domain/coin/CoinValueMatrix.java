package com.example.demo.domain.coin;

import com.example.demo.domain.rank.Rank;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "coin_value_matrix")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoinValueMatrix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Era era;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "user_rank")
    private Rank rank;

    @Column(nullable = false)
    private double multiplier;
}
