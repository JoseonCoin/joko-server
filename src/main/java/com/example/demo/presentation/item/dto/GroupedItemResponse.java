package com.example.demo.presentation.item.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GroupedItemResponse {
    private final String rank;
    private final List<ItemInfo> items;

    @Getter
    @AllArgsConstructor
    public static class ItemInfo {
        private final Long itemId;
        private final String name;
        private final String imageUrl;
        private final int price;
    }
}
