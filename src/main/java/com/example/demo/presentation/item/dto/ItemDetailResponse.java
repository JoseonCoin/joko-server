package com.example.demo.presentation.item.dto;

import com.example.demo.domain.item.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemDetailResponse {
    private final String description;
    private final String name;
    private final int price;
    private final String imageUrl;
    private final boolean owned;

    public static ItemDetailResponse from(Item item, boolean owned) {
        return new ItemDetailResponse(
            item.getDescription(),
            item.getName(),
            item.getPrice(),
            item.getImageUrl(),
            owned
        );
    }
}
