package com.example.demo.domain.item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserItemRepository extends JpaRepository<UserItem, Long> {
    boolean existsByUserIdAndItemId(Long userId, Long itemId);
}
