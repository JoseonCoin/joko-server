package com.example.demo.service.item;

import com.example.demo.domain.item.Item;
import com.example.demo.domain.item.ItemRepository;
import com.example.demo.domain.item.UserItem;
import com.example.demo.domain.item.UserItemRepository;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserItemService {
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final UserItemRepository userItemRepository;

    @Transactional
    public void buyItem(Long userId, Long itemId) {
        User user = userRepository.findById(userId).orElseThrow();
        Item item = itemRepository.findById(itemId).orElseThrow();
        if (user.getRank() != item.getJob().getRank()) {
            throw new IllegalArgumentException("해당 신분의 직업만 구매할 수 있습니다.");
        }
        user.spendCoin(item.getPrice());
        userItemRepository.save(UserItem.builder().user(user).item(item).build());
    }

    @Transactional
    public void equipItem(Long userItemId) {
        UserItem userItem = userItemRepository.findById(userItemId).orElseThrow();
        userItem.equip();
    }

    @Transactional
    public void unequipItem(Long userItemId) {
        UserItem userItem = userItemRepository.findById(userItemId).orElseThrow();
        userItem.unequip();
    }
}
