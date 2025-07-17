package com.example.demo.presentation.event.dto;

import com.example.demo.domain.event.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EraChangeResponse {
    private String title;
    private int year;
    private String description;
    private String imageUrl;

    public static EraChangeResponse from(Event event) {
        return new EraChangeResponse(
                event.getTitle(),
                event.getYear(),
                event.getDescription(),
                event.getImageUrl()
        );
    }
}
