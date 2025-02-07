package com.gildedrose;

public class GildedRose {
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        for (Item item : items) {
            manageTimePassing(item);
            if (isANormalItem(item)) {
                NormalItem normalItem = new NormalItem(item);
                normalItem.updateQuality();
            } else {
                specialItemRefining(item);
            }

        }
    }

    public void specialItemRefining(Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros" -> {
            }
            case "Backstage passes to a TAFKAL80ETC concert" -> {
                updateQualityForBackstagePasses(item);
                break;
            }
            case "Aged Brie" -> {
                updateQualityForAgedBrieItem(item);
                break;
            }
            default -> {
                break;
            }
        }
    }

    private void updateQualityForBackstagePasses(Item item) {
        if(!item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
            return;
        }
        if (item.quality >= 50) {
           return;
        }
        if (item.sellIn <= 0) {
            item.quality = 0;
            return;
        }
        if (item.sellIn < 6) {
            item.quality += 3;
            return;
        }
        if (item.sellIn < 11) {
            item.quality += 2;
            return;
        }
        item.quality += 1;
    }

    private void updateQualityForAgedBrieItem(Item item) {
        if(!item.name.equals("Aged Brie")){
            return;
        }
        if (item.quality >= 50) {
            return;
        }
        if(item.sellIn <= 0){
           item.quality += 2;
           return;
        }
        item.quality += 1;
    }


    public boolean isANormalItem(Item item) {
        return !item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")
                && !item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    public void manageTimePassing(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn -= 1;
    }
}
