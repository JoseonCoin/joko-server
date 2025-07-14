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
}
