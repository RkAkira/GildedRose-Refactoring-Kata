package com.gildedrose.Items;

import com.gildedrose.Item;

public class AgedBrieItem extends NormalItem {

    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (this.getQuality() >= 50) {
            return;
        }
        if(this.getSellIn() <= 0){
            this.setQuality(this.getQuality() + 2);
            return;
        }
        this.setQuality(this.getQuality() + 1);
    }
}
