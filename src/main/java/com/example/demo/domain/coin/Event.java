package com.example.demo.domain.coin;

public enum Event {
    HANYANG_MOVE(Era.JEON_GI, "한양 천도"),
    SANGPYEONGCHANG(Era.JEON_GI, "상평창 설립"),
    IMJINWAR(Era.JUNG_GI, "임진왜란"),
    SANGPYEONGTONGBO(Era.JUNG_GI, "상평통보 대량 발행"),
    YOUNGJO_JEONGJO(Era.HU_GI, "영조~정조 상평통보 과다 주조"),
    HONGGYEONGNAE(Era.HU_GI, "홍경래의 난"),
    ;

    private final Era era;
    private final String description;

    Event(Era era, String description) {
        this.era = era;
        this.description = description;
    }

    public Era getEra() { return era; }
    public String getDescription() { return description; }
}
