package com.gildedrose;

public class NormalItem  {

    private final Item item;

    public NormalItem(Item item) {
        this.item = item;
    }

    void updateQuality() {
        if(item.quality >= 50) {
            return;
        }
        if(item.sellIn < 0) {
            decreaseQuality();
        }
        decreaseQuality();
    }

    private void decreaseQuality() {
        if (item.quality <= 0) {
            return;
        }
        item.quality  -= 1;
    }
}
