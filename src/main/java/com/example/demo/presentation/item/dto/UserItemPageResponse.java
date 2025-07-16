package com.example.demo.presentation.item.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserItemPageResponse {
    private final String job;
    private final int totalCount;
    private final int ownedCount;
    private final List<UserItemInfo> items;

    @Getter
    @AllArgsConstructor
    public static class UserItemInfo {
        private final Long itemId;
        private final String name;
        private final String imageUrl;
        private final boolean owned;
    }
}
