package com.gildedrose;

public class GildedRose {
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isANormalItem(item)) {
                if (item.quality > 0) {
                    item.quality -= 1;
                }
            } else {
                specialItemRefining(item);
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn -= 1;
            }

            if (item.sellIn < 0) {
                if (isANormalItem(item)) {
                    if (item.quality > 0) {
                        item.quality -= 1;
                    }
                } else {
                    specialItemRefining(item);
                }
            }
        }
    }

    public void specialItemRefining(Item item){
        if (!item.name.equals("Sulfuras, Hand of Ragnaros") && item.quality < 50) {
            item.quality += 1;
            if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
                if (item.sellIn < 11) {
                    item.quality += 1;
                }
                if (item.sellIn < 6) {
                    item.quality += 1;
                }
                if(item.sellIn <= 0){
                    item.quality = 0;
                }
            }
        }
    }

    public boolean isANormalItem(Item item){
        return !item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert") && !item.name.equals("Sulfuras, Hand of Ragnaros");
    }
}
