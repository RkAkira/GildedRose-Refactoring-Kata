package com.gildedrose.Items;

import com.gildedrose.Item;

public class NormalItem  {

    private final Item item;

    public NormalItem(Item item) {
        this.item = item;
    }

    public void updateQuality() {
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

    public int getQuality(){
        return item.quality;
    }

    protected void setQuality(int quality) {
        item.quality = quality;
    }

    public int getSellIn(){
        return item.sellIn;
    }

    protected void setSellIn(int sellIn) {
        item.sellIn = sellIn;
    }

    @Override
    public String toString() {
        return item.toString();
    }

    public void manageTimePassing() {
        item.sellIn -= 1;
    }
}
