package com.example.demo.presentation.event.dto;

import com.example.demo.domain.coin.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EraChangeResponse {
    private int year;
    private String description;
    private String imageUrl;

    public static EraChangeResponse from(Event event) {
        return new EraChangeResponse(
                event.getYear(),
                event.getDescription(),
                event.getImageUrl()
        );
    }
}