package com.example.demo.domain.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import com.example.demo.domain.rank.Rank;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String accountId;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rank rank = Rank.CHEONMIN;

    @Column(nullable = false)
    private int coin = 0;

    // 코인 사용
    public void spendCoin(int amount) {
        if (this.coin < amount) throw new IllegalArgumentException("코인이 부족합니다.");
        this.coin -= amount;
    }

    // 코인 얻기
    public void earnCoin(int amount) {
        this.coin += amount;
    }
}
