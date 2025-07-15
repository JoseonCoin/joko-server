package com.example.demo.service.coin;

import com.example.demo.domain.coin.CoinValueMatrix;
import com.example.demo.domain.coin.CoinValueMatrixRepository;
import com.example.demo.domain.coin.Era;
import com.example.demo.domain.rank.Rank;
import com.example.demo.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoinValueService {
    private final CoinValueMatrixRepository coinValueMatrixRepository;

    public double getMultiplier(Era era, Rank rank) {
        return coinValueMatrixRepository.findByEraAndRank(era, rank)
                .map(CoinValueMatrix::getMultiplier)
                .orElse(1.0);
    }

    public int getEffectiveCoinValue(User user, int baseValue) {
        double multiplier = getMultiplier(user.getEra(), user.getRank());
        return (int) Math.ceil(baseValue * multiplier);
    }
}
