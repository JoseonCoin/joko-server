package com.example.demo.domain.coin;

import lombok.Getter;

@Getter
public enum Event {
    // 전기
    HUNMINJEONGEUM(1443, Era.JEON_GI, 1.0, "훈민정음 창제", "https://drive.google.com/file/d/1fXMQA49phpOo8wkhRnc2JBdC8EQcDPUb/view?usp=sharing"),
    SANGPYEONGCHANG(1433, Era.JEON_GI, 1.2, "상평창 설립", "https://drive.google.com/file/d/1MRPYCGSOFwBk112JQ-auPJy5eQ9hIJZj/view?usp=sharing"),
    // 중기
    IMJINWAR(1592, Era.JUNG_GI, 1.5, "임진왜란", "https://drive.google.com/file/d/1O6dxNBDj1WuJq_7meauT9FnJHp0CVsW3/view?usp=sharing"),
    SANGPYEONGTONGBO(1678, Era.JUNG_GI, 1.2, "상평통보 대량 발행", "https://drive.google.com/file/d/1fFmc2sUrj2zPG3u5QdvnHfl2-M9w30O6/view?usp=sharing"),
    // 후기
    DONGHAK(1894, Era.HU_GI, 0.5, "동학농민운동", "https://drive.google.com/file/d/1YOgnWn6BBo9Wn8lrSBksbpjW_k1Kc9NL/view?usp=sharing"),
    SHINHAE_TONGGONG(1791, Era.HU_GI, 0.7, "신해통공", "https://drive.google.com/file/d/1bEJkMgwcMZ2spyXzb_bu8PSVzUxFnat9/view?usp=sharing"),
    HONGGYEONGNAE(1811, Era.HU_GI, 1.2, "홍경래의 난", "https://drive.google.com/file/d/1ZX_in1LaKzkNuaNrryIvhu4tkOlvjSrp/view?usp=sharing");

    private final int year;
    private final Era era;
    private final double multiplier;
    private final String description;
    private final String imageUrl;

    Event(int year, Era era, double multiplier, String description, String imageUrl) {
        this.year = year;
        this.era = era;
        this.multiplier = multiplier;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Era getEra() { return era; }
    public String getDescription() { return description; }
    public String getImageUrl() { return imageUrl; }
}
