package com.example.demo.presentation.item.dto;

import com.example.demo.domain.item.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemSimpleResponse {
    private final String name;
    private final int price;
    private final String imageUrl;

    public static ItemSimpleResponse from(Item item) {
        return new ItemSimpleResponse(
            item.getName(),
            item.getPrice(),
            item.getImageUrl()
        );
    }
}
