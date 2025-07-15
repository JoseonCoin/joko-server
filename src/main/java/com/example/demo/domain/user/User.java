package com.example.demo.domain.user;

import com.example.demo.domain.rank.Rank;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Setter
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

    @Column(nullable = false, name = "user_rank")
    private Rank rank;

    @Column(nullable = false)
    private int coin;

    public void addCoin(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("코인 추가 금액은 음수일 수 없습니다.");
        }
        this.coin += amount;
    }
}
