package com.jinoh.rareitem.backend.Controller;

import com.jinoh.rareitem.backend.domain.ClothingItem;
import com.jinoh.rareitem.backend.repository.ClothingItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ClothingItemController {

    private final ClothingItemRepository repository;

    public ClothingItemController(ClothingItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ClothingItem> getAllItems() {
        return repository.findAll();
    }

    @PostMapping
    public ClothingItem createItem(@RequestBody ClothingItem item) {
        return repository.save(item);
    }

    @GetMapping("/{id}")
    public ClothingItem getItem(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping("/{id}/vote")
    public ClothingItem voteItem(@PathVariable Long id) {
        ClothingItem item = repository.findById(id).orElseThrow();
        item.setRarityPercent(item.getRarityPercent() + 1); // 희소성 +1
        return repository.save(item);
    }
}