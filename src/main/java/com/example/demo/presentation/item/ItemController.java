package com.example.demo.presentation.item;

import com.example.demo.presentation.item.dto.BuyItemRequest;
import com.example.demo.service.item.UserItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {
    private final UserItemService userItemService;

    @PostMapping("/buy")
    public void buy(@RequestBody BuyItemRequest request) {
        userItemService.buyItem(request);
    }

    @PostMapping("/equip")
    public void equip(@RequestParam Long userItemId) {
        userItemService.equipItem(userItemId);
    }

    @PostMapping("/unequip")
    public void unequip(@RequestParam Long userItemId) {
        userItemService.unequipItem(userItemId);
    }
}
