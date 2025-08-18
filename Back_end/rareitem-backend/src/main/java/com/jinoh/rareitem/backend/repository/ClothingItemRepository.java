package com.jinoh.rareitem.backend.repository;

import com.jinoh.rareitem.backend.domain.ClothingItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothingItemRepository extends JpaRepository<ClothingItem, Long> {

}
