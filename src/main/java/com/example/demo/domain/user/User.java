package com.example.demo.domain.user;

import com.example.demo.domain.coin.Era;
import com.example.demo.domain.rank.Rank;
import com.example.demo.domain.rank.Job;
import jakarta.persistence.*;
import lombok.*;

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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "user_rank")
    private Rank rank = Rank.CHEONMIN;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Job job = Job.NOBI;

    @Column(nullable = false)
    private int coin = 0;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Era era = Era.JEON_GI;

    // 코인 사용
    public void spendCoin(int amount) {
        if (this.coin < amount) throw new IllegalArgumentException("코인이 부족합니다.");
        this.coin -= amount;
    }

    // 코인 얻기
    public void earnCoin(int amount) {
        this.coin += amount;
    }

    public void addCoin(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("코인 추가 금액은 음수일 수 없습니다.");
        }
    }

    public void promoteRankAndJob (Rank nextRank, Job nextJob){
        this.rank = nextRank;
        this.job = nextJob;
    }
    }
}
