package com.example.demo.service.item;

import com.example.demo.domain.item.Item;
import com.example.demo.domain.item.ItemRepository;
import com.example.demo.domain.item.UserItem;
import com.example.demo.domain.item.UserItemRepository;
import com.example.demo.domain.rank.Job;
import com.example.demo.domain.rank.Rank;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.repository.UserRepository;
import com.example.demo.presentation.item.dto.BuyItemRequest;
import com.example.demo.presentation.item.dto.GroupedItemResponse;
import com.example.demo.presentation.item.dto.UserItemPageResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserItemService {
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final UserItemRepository userItemRepository;

    @Transactional
    public void buyItem(BuyItemRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow();
        Item item = itemRepository.findById(request.getItemId()).orElseThrow();
        if (user.getRank() != item.getJob().getRank()) {
            throw new IllegalArgumentException("해당 신분의 직업만 구매할 수 있습니다.");
        }
        int cost = (int) Math.ceil(item.getPrice() * user.getEvent().getMultiplier());
        if (user.getCoin() < cost) throw new IllegalArgumentException("코인이 부족합니다.");
        user.spendCoin(cost);
        userItemRepository.save(UserItem.builder().user(user).item(item).build());
    }

    @Transactional
    public void sellItem(Long userItemId) {
        UserItem userItem = userItemRepository.findById(userItemId).orElseThrow();
        User user = userItem.getUser();
        Item item = userItem.getItem();
        int salePrice = (int) Math.ceil(item.getPrice() * user.getEvent().getMultiplier());
        user.earnCoin(salePrice);
        userItemRepository.delete(userItem);
    }

    @Transactional
    public UserItemPageResponse getUserItemPage(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Job job = user.getJob();

        List<Item> allItems = itemRepository.findByJob(job);

        Set<Long> ownedItemIds = userItemRepository.findByUserId(userId)
                .stream().map(ui -> ui.getItem().getId()).collect(Collectors.toSet());

        List<UserItemPageResponse.UserItemInfo> items = allItems.stream()
                .map(item -> new UserItemPageResponse.UserItemInfo(
                        item.getId(),
                        item.getName(),
                        item.getImageUrl(),
                        ownedItemIds.contains(item.getId())
                ))
                .collect(Collectors.toList());

        int totalCount = allItems.size();
        int ownedCount = (int) items.stream().filter(UserItemPageResponse.UserItemInfo::isOwned).count();

        return new UserItemPageResponse(job.name(), totalCount, ownedCount, items);
    }

    @Transactional
    public List<GroupedItemResponse> getItemsGroupedByRank() {
        List<Item> allItems = itemRepository.findAll();

        Map<Rank, List<Item>> grouped = allItems.stream()
                .collect(Collectors.groupingBy(item -> item.getJob().getRank()));

        List<GroupedItemResponse> result = new ArrayList<>();
        for (Map.Entry<Rank, List<Item>> entry : grouped.entrySet()) {
            Rank rank = entry.getKey();
            List<GroupedItemResponse.ItemInfo> items = entry.getValue().stream()
                    .map(item -> new GroupedItemResponse.ItemInfo(
                            item.getId(),
                            item.getName(),
                            item.getImageUrl(),
                            item.getPrice()
                    ))
                    .collect(Collectors.toList());
            result.add(new GroupedItemResponse(rank.name(), items));
        }
        result.sort(Comparator.comparing(r -> r.getRank()));
        return result;
    }
}
