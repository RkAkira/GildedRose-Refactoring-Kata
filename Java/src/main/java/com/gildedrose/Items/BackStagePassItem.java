package com.gildedrose.Items;

import com.gildedrose.Item;

public class BackStagePassItem extends NormalItem {


    public BackStagePassItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (this.getQuality() >= 50) {
            return;
        }
        if (this.getSellIn() <= 0) {
            this.setQuality(0);
            return;
        }
        if (this.getSellIn() < 6) {
            this.setQuality(this.getQuality() + 3);
            return;
        }
        if (this.getSellIn() < 11) {
            this.setQuality(this.getQuality() + 2);
            return;
        }
        this.setQuality(this.getQuality() +1);
    }

    @Override
    public String toString() {
        return "BackStagePassItem{}";
    }
}
