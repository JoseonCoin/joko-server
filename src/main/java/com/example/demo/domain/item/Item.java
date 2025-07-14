package com.example.demo.domain.item;

import com.example.demo.domain.rank.Job;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Job job;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;
}
