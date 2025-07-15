package com.example.demo.service.user;

import com.example.demo.domain.coin.Era;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public static final int cost = 15;

    @Transactional
    public void changeEra(Long userId, Era newEra) {
        User user = userRepository.findById(userId).orElseThrow();

        if (user.getEra() == newEra) {
            throw new IllegalArgumentException("이미 해당 시대입니다.");
        }
        if (user.getCoin() < cost) {
            throw new IllegalArgumentException("코인이 부족합니다.");
        }

        user.spendCoin(cost);
        user.setEra(newEra);
    }
}
