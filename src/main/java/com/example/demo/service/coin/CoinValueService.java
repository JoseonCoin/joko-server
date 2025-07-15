package com.example.demo.service.coin;

import com.example.demo.domain.coin.CoinValueMatrix;
import com.example.demo.domain.coin.CoinValueMatrixRepository;
import com.example.demo.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoinValueService {
    private final CoinValueMatrixRepository matrixRepo;

    public int getEffectiveCoinValue(User user, int baseValue) {
        double multiplier = matrixRepo.findByEraAndRank(user.getEra(), user.getRank())
                .map(CoinValueMatrix::getMultiplier)
                .orElse(1.0);
        return (int) Math.ceil(baseValue * multiplier);
    }
}
