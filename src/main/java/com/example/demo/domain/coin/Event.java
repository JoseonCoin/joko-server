package com.example.demo.domain.coin;

import lombok.Getter;

@Getter
public enum Event {
    // 전기
    HUNMINJEONGEUM(1443, Era.JEON_GI, 1.0, "훈민정음 창제", "https://example.com/images/hunminjeongeum.png"),
    SANGPYEONGCHANG(1433, Era.JEON_GI, 1.2, "상평창 설립", "https://example.com/images/sangpyeongchang.png"),
    // 중기
    IMJINWAR(1592, Era.JUNG_GI, 1.5, "임진왜란", "https://example.com/images/imjinwar.png"),
    SANGPYEONGTONGBO(1678, Era.JUNG_GI, 1.2, "상평통보 대량 발행", "https://example.com/images/sangpyeongtongbo.png"),
    // 후기
    DONGHAK(1894, Era.HU_GI, 0.5, "동학농민운동", "https://example.com/images/donghak.png"),
    SHINHAE_TONGGONG(1791, Era.HU_GI, 0.7, "신해통공", "https://example.com/images/shinhae.png"),
    HONGGYEONGNAE(1811, Era.HU_GI, 1.2, "홍경래의 난", "https://example.com/images/honggyeongnae.png");

    private final int year;
    private final Era era;
    private final double multiplier;
    private final String description;
    private final String imageUrl; // 이미지 필드 추가

    Event(int year, Era era, double multiplier, String description, String imageUrl) {
        this.year = year;
        this.era = era;
        this.multiplier = multiplier;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Era getEra() { return era; }
    public String getDescription() { return description; }
    public String getImageUrl() { return imageUrl; } // Getter 추가
}
