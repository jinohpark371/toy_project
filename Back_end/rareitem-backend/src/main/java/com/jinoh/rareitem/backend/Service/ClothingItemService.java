package com.jinoh.rareitem.backend.Service;

import com.jinoh.rareitem.backend.domain.ClothingItem;
import com.jinoh.rareitem.backend.repository.ClothingItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothingItemService {

    private final ClothingItemRepository repository;

    public ClothingItemService(ClothingItemRepository repository) {
        this.repository = repository;
    }

    public List<ClothingItem> getAllItems() {
        return repository.findAll();
    }

    public ClothingItem createItem(ClothingItem item) {
        return repository.save(item);
    }

    public ClothingItem getItem(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public ClothingItem voteItem(Long id) {
        ClothingItem item = repository.findById(id).orElseThrow();
        item.setRarityPercent(item.getRarityPercent() + 1); // 희소성 +1
        return repository.save(item);
    }
}