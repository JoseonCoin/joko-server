package com.example.demo.domain.item;

import com.example.demo.domain.rank.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByJob(Job job);
}
