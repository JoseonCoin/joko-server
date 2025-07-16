package com.example.demo.service.user;

import com.example.demo.domain.coin.Era;
import com.example.demo.domain.coin.Event;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public static final int cost = 15;

    @Transactional
    public Event changeEra(Long userId, Era newEra) {
        User user = userRepository.findById(userId).orElseThrow();

        if (user.getCoin() < cost) throw new IllegalArgumentException("코인이 부족합니다.");

        List<Event> events = Arrays.stream(Event.values())
                .filter(e -> e.getEra() == newEra)
                .collect(Collectors.toList());

        Event randomEvent = events.get(new Random().nextInt(events.size()));

        user.spendCoin(cost);
        user.changeEraAndEvent(newEra, randomEvent);

        return randomEvent;
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    public User getUserByAccountId(String accountId) {
        return userRepository.findByAccountId(accountId).orElseThrow();
    }
}
