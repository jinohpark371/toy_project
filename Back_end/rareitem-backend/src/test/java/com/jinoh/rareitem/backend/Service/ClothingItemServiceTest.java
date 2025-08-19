package com.jinoh.rareitem.backend.Service;

import com.jinoh.rareitem.backend.domain.ClothingItem;
import com.jinoh.rareitem.backend.repository.ClothingItemRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class ClothingItemServiceTest {

    private final ClothingItemRepository repository = Mockito.mock(ClothingItemRepository.class);
    private final ClothingItemService service = new ClothingItemService(repository);

    @Test
    void getAllItems() {
        // given
        ClothingItem item1 = new ClothingItem();
        item1.setId(1L);
        item1.setName("상의");
        item1.setPrice(11000);

        ClothingItem item2 = new ClothingItem();
        item2.setId(2L);
        item2.setName("하의");
        item2.setPrice(12000);

        given(repository.findAll()).willReturn(Arrays.asList(item1, item2));

        // when
        List<ClothingItem> items = service.getAllItems();

        // then
        assertEquals(2, items.size());
        assertEquals("상의", items.get(0).getName());
    }

    @Test
    void createItem() {
        // given
        ClothingItem item = new ClothingItem();
        item.setName("운동화");

        given(repository.save(item)).willReturn(item);

        // when
        ClothingItem saved = service.createItem(item);

        // then
        assertNotNull(saved);
        assertEquals("운동화", saved.getName());
    }

    @Test
    void getItem() {
        // given
        ClothingItem item = new ClothingItem();
        item.setId(1L);
        item.setName("모자");

        given(repository.findById(1L)).willReturn(Optional.of(item));

        // when
        ClothingItem found = service.getItem(1L);

        // then
        assertNotNull(found);
        assertEquals("모자", found.getName());
    }

    @Test
    void voteItem() {
        // given
        ClothingItem item = new ClothingItem();
        item.setId(1L);
        item.setRarityPercent(10);

        given(repository.findById(1L)).willReturn(Optional.of(item));
        given(repository.save(item)).willReturn(item);

        // when
        ClothingItem updated = service.voteItem(1L);

        // then
        assertEquals(11, updated.getRarityPercent());
    }
}
