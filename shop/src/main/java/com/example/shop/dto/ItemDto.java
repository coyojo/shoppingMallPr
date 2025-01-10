package com.example.shop.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ItemDto {
    // 데이터를 주고 받을 때는 Entity 클래스 자체를 반환하면 안 되고 데이터 전달용 객체(DTO)를 생성해서 사용한다.
    // DB설계를 외부에 노출할 필요도 없으며, 요청과 응답 객체가 항상 엔티티와 같지 않기 때문
    private Long id;

    private String itemNm;

    private Integer price;

    private String itemDetail;

    private String sellStatCd;

    private LocalDateTime regTime;

    private LocalDateTime updateTime;


}
