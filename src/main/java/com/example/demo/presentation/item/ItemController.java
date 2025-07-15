package com.example.demo.presentation.item;

import com.example.demo.presentation.item.dto.BuyItemRequest;
import com.example.demo.service.item.UserItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.demo.domain.item.ItemRepository;
import java.util.List;

import com.example.demo.presentation.item.dto.ItemSimpleResponse;
import com.example.demo.presentation.item.dto.ItemDetailResponse;
import com.example.demo.domain.item.UserItemRepository;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {
    private final UserItemService userItemService;
    private final ItemRepository itemRepository;
    private final UserItemRepository userItemRepository;

    @PostMapping("/buy")
    public void buy(@RequestBody BuyItemRequest request) {
        userItemService.buyItem(request);
    }

    @PostMapping("/sell")
    public void sell(@RequestParam Long userItemId) {
        userItemService.sellItem(userItemId);
    }

    @GetMapping("/all")
    public List<ItemSimpleResponse> getAllItems() {
        return itemRepository.findAll().stream()
            .map(ItemSimpleResponse::from)
            .toList();
    }

    @GetMapping("/detail/{itemId}")
    public ItemDetailResponse getItemDetail(@PathVariable Long itemId, @RequestParam Long userId) {
        boolean owned = userItemRepository.existsByUserIdAndItemId(userId, itemId);
        return itemRepository.findById(itemId)
            .map(item -> ItemDetailResponse.from(item, owned))
            .orElseThrow();
    }
}
