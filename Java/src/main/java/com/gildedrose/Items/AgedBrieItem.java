package com.gildedrose.Items;

import com.gildedrose.Item;

public class AgedBrieItem extends NormalItem {

    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (this.getQuality() >= MAX_QUALITY) {
            return;
        }
        if(this.getSellIn() <= EXPIRATION_DAY){
            this.setQuality(this.getQuality() + VARIATION_RATE*2);
            return;
        }
        this.setQuality(this.getQuality() + VARIATION_RATE);
    }
}
