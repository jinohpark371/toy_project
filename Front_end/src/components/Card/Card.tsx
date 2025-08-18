import type { ClothingItem } from "../../types/item.ts";
import * as S from "./Card.styles.ts";

export default function Card({ item }: { item: ClothingItem }) {
  return (
    <S.CardBox>
      <S.Thumb>
        <img src={item.imageUrl} alt={item.title} />
      </S.Thumb>

      <S.Meta>
        <S.Title>{item.title}</S.Title>
        <S.Price>₩{item.price.toLocaleString()}</S.Price>

        <S.Row>
          {/* 색상칩 */}
          {item.colors && (
            <S.MiniSwatches>
              {item.colors.map((c) => (
                <S.Mini key={c} color={c} />
              ))}
            </S.MiniSwatches>
          )}

          {/* 별점 */}
          {item.rating && <S.Rating>★ {item.rating}</S.Rating>}
        </S.Row>

        {/* 태그 */}
        <S.TagLine>
          {item.tags.map((t) => (
            <S.Chip key={t}>{t}</S.Chip>
          ))}
        </S.TagLine>

        {/* 희소성 */}
{item.rarityPercent !== undefined && (
  <S.RarityWrapper>
    <S.RarityLabel>희소성</S.RarityLabel>
    <S.RarityBar>
      <S.RarityFill style={{ width: `${item.rarityPercent}%` }} />
    </S.RarityBar>
    <S.RarityValue>{item.rarityPercent}%</S.RarityValue>
  </S.RarityWrapper>
)}

      </S.Meta>
    </S.CardBox>
  );
}
