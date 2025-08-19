package com.jinoh.rareitem.backend.Service;
import com.jinoh.rareitem.backend.domain.ClothingItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ClothingItemIntegrationTest {

    @Autowired
    private ClothingItemService service;

    @Test
    @DisplayName("아이템 생성 및 해당 아이템 찾기")
    @Commit
    void createAndFindItem() {
        // given
        ClothingItem item = new ClothingItem();
        item.setName("실행 테스트");
        item.setRarityPercent(0);

        // when
        ClothingItem saved = service.createItem(item);
        ClothingItem found = service.getItem(saved.getId());

        // then
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo("실행 테스트");
        assertThat(found.getRarityPercent()).isEqualTo(0);
    }

    @Test
    @DisplayName("아이템 투표 테스트")
    @Commit
    void voteItem_shouldIncreaseRarity() {
        // given
        ClothingItem item = new ClothingItem();
        item.setName("투표 테스트");
        item.setRarityPercent(5);

        ClothingItem saved = service.createItem(item);

        // when
        ClothingItem updated = service.voteItem(saved.getId());

        // then
        assertThat(updated.getRarityPercent()).isEqualTo(6);
    }
}
