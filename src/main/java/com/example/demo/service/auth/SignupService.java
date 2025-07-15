package com.example.demo.service.auth;

import com.example.demo.domain.coin.Era;
import com.example.demo.domain.rank.Rank;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.exception.UserAlreadyExistsException;
import com.example.demo.domain.user.repository.UserRepository;
import com.example.demo.presentation.auth.dto.request.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signup(SignupRequest request) {
        if (userRepository.findByAccountId(request.accountId()).isPresent()) {
            throw UserAlreadyExistsException.EXCEPTION;
        }

        User user = User.builder()
                .accountId(request.accountId())
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .rank(Rank.CHEONMIN)
                .era(Era.JEON_GI)
                .build();

        userRepository.save(user);
    }
}
