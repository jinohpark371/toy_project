package com.jinoh.rareitem.backend.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ClothingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int price;
    private String imageUrl;


    @ManyToMany
    @JoinTable(
            name = "clothing_item_tag",    // 중간 테이블 이름
            joinColumns = @JoinColumn(name = "clothing_item_id"), //현재 엔티티의 기본키
            inverseJoinColumns = @JoinColumn(name = "tag_id")  //반대편 엔티티의 기본기
    )
    private List<Tag> tags = new ArrayList<>();

    private double rating;
    private int rarityPercent;
}
