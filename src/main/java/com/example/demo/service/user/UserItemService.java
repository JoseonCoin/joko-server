package com.example.demo.service.user;

import com.example.demo.domain.item.Item;
import com.example.demo.domain.item.ItemRepository;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserItem;
import com.example.demo.domain.user.UserItemRepository;
import com.example.demo.domain.user.UserRepository;
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
        if (user.getCoin() < item.getPrice()) {
            throw new IllegalArgumentException("코인이 부족합니다.");
        }
        user.setCoin(user.getCoin() - item.getPrice());
        userItemRepository.save(UserItem.builder().user(user).item(item).build());
    }

    @Transactional
    public void useItem(Long userItemId) {
        UserItem userItem = userItemRepository.findById(userItemId).orElseThrow();
        if (userItem.isUsed()) {
            throw new IllegalStateException("이미 사용한 아이템입니다.");
        }
        userItem.setUsed(true);
        // 아이템 효과 적용 로직은 필요에 따라 추가
    }
} 