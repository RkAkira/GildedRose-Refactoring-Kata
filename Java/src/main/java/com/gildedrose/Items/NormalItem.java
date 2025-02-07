package com.gildedrose.Items;

import com.gildedrose.Item;

public class NormalItem  {

    private final Item item;
    public static final int EXPIRATION_DAY = 0;
    public static final int MIN_QUALITY = 0;
    public static final int MAX_QUALITY = 50;
    public static final int VARIATION_RATE = 1;

    public NormalItem(Item item) {
        this.item = item;
    }

    public void updateQuality() {
        if(item.quality >= MAX_QUALITY) {
            return;
        }
        if(item.sellIn < EXPIRATION_DAY) {
            decreaseQuality();
        }
        decreaseQuality();
    }

    private void decreaseQuality() {
        if (item.quality <= MIN_QUALITY) {
            return;
        }
        item.quality  -= VARIATION_RATE;
    }

    public int getQuality(){
        return item.quality;
    }

    protected void setQuality(int quality) {
        item.quality = quality;
    }

    public int getSellIn(){
        return item.sellIn;
    }

    @Override
    public String toString() {
        return item.toString();
    }

    public void manageTimePassing() {
        item.sellIn -= VARIATION_RATE;
    }
}
