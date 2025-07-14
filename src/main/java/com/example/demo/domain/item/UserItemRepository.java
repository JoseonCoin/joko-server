package com.example.demo.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserItemRepository extends JpaRepository<UserItem, Long> {
} 