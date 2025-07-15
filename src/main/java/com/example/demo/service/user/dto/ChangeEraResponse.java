package com.example.demo.service.user.dto;

import com.example.demo.domain.coin.Era;
import com.example.demo.domain.coin.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChangeEraResponse {
    private Era era;
    private String eventName;
    private int eventYear;
    private String eventDescription;
    private double multiplier;

    public static ChangeEraResponse of(Era era, Event event) {
        return new ChangeEraResponse(
                era,
                event.name(),
                event.getYear(),
                event.getDescription(),
                event.getMultiplier()
        );
    }
}
