package com.example.demo.domain.item;

import com.example.demo.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(nullable = false, name = "is_using")
    private boolean using = false;

    // 장착
    public void equip() {
        if (this.using) throw new IllegalStateException("이미 장착 중인 아이템입니다.");
        this.using = true;
    }

    // 해제
    public void unequip() {
        if (!this.using) throw new IllegalStateException("이미 해제된 아이템입니다.");
        this.using = false;
    }
}
