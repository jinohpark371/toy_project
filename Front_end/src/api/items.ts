import type { ClothingItem } from "../types/item";

export const ITEMS: ClothingItem[] = [
  {
    id: "c001",
    title: "테크 웨더 재킷",
    price: 129000,
    imageUrl: "https://picsum.photos/seed/jacket1/600/400",
    colors: ["#000000", "#2f4f4f"],  
    tags: ["아우터", "테크웨어", "방수"],
    rating: 4.6,
    ratingCount: 47,
    rarityPercent: 92,
  },
  {
    id: "c002",
    title: "오버핏 데님 셔츠",
    price: 59000,
    imageUrl: "https://picsum.photos/seed/denim1/600/400",
    tags: ["셔츠", "데님", "캐주얼"],
    colors: ["#000000", "#2f4f4f"],  
    rating: 4.2,
    ratingCount: 31,
    rarityPercent: 85,
  },
];
