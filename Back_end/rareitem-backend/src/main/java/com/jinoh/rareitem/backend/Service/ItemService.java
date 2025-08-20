package com.jinoh.rareitem.backend.Service;

import com.jinoh.rareitem.backend.domain.ClothingItem;

import java.util.List;

public interface ItemService<T> {
    List<T> getAllItems();
    T createItem(T item);
    T getItem(Long id);
    T voteItem(Long id);
}