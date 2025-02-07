package com.gildedrose.Items;

import com.gildedrose.Item;

public class BackStagePassItem extends NormalItem {

    public static final int FIRST_CEILING = 11;
    public static final int SECOND_CEILING = 6;

    public BackStagePassItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (this.getQuality() >= MAX_QUALITY) {
            return;
        }
        if (this.getSellIn() <= EXPIRATION_DAY) {
            this.setQuality(MIN_QUALITY);
            return;
        }
        if (this.getSellIn() < FIRST_CEILING) {
            if (this.getSellIn() < SECOND_CEILING) {
                this.setQuality(this.getQuality() + VARIATION_RATE*3);
                return;
            }
            this.setQuality(this.getQuality() + VARIATION_RATE*2);
            return;
        }
        this.setQuality(this.getQuality() + VARIATION_RATE);
    }
}
