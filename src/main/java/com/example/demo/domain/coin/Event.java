package com.example.demo.domain.coin;

import lombok.Getter;

@Getter
public enum Event {
    // 전기
    HUNMINJEONGEUM(1443, Era.JEON_GI, 1.0, "훈민정음 창제"),
    SANGPYEONGCHANG(1433, Era.JEON_GI, 1.2, "상평창 설립"),
    // 중기
    IMJINWAR(1592, Era.JUNG_GI, 1.5, "임진왜란"),
    SANGPYEONGTONGBO(1678, Era.JUNG_GI, 1.2, "상평통보 대량 발행"),
    // 후기
    DONGHAK(1894, Era.HU_GI, 0.5, "동학농민운동"),
    SHINHAE_TONGGONG(1791, Era.HU_GI, 0.7, "신해통공"),
    HONGGYEONGNAE(1811, Era.HU_GI, 1.2, "홍경래의 난");

    private final int year;
    private final Era era;
    private final double multiplier;
    private final String description;

    Event(int year, Era era, double multiplier, String description) {
        this.year = year;
        this.era = era;
        this.multiplier = multiplier;
        this.description = description;
    }

    public Era getEra() { return era; }
    public String getDescription() { return description; }
}
