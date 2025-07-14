package com.example.demo.domain.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
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
}
