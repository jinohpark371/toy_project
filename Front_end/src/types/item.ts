export type HexColor = `#${string}`;

export interface ClothingItem {
  id: string; // 고유 ID
  title: string; // 옷 이름
  imageUrl: string; // 옷 사진
  price: number; // 가격
  tags: string[]; // 태그 (예: "데님", "커스텀")
  colors: HexColor[];
  rarityPercent: number; // 희소성 % (투표로 올라가는 값)
  rating: number; // 평균 별점 (0 ~ 5)
  ratingCount: number; // 리뷰 개수
}
