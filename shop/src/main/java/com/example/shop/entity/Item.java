package com.example.shop.entity;

import com.example.shop.constant.ItemSellStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "item")
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long id;  // 상품 코드
    
    @Column(nullable = false, length = 50)
    private String itemNm;   // 상품명
    
    @Column(name = "price", nullable = false)
    private int price;   //가격
    
    @Column(nullable = false)
    private int stockNumber;   // 재고수량
    
    @Lob
    @Column(nullable = false)
    private String itemDetail;   // 상품 상세 설명
    
    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;   // 상품 판매 상태
    
    private LocalDateTime regTime;   // 등록 시간
    private LocalDateTime updateTime;  // 수정시간
    
}
