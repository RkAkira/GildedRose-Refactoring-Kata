package com.gildedrose.Items;

import com.gildedrose.Item;

public class SulfurasItem extends NormalItem {
    public static final int SULFURAS_QUALITY = 80;

    public SulfurasItem(Item item) {
        super(item);
        this.setQuality(SULFURAS_QUALITY);
    }

    @Override
    public void updateQuality() {
        return;
    }

    @Override
    public void manageTimePassing() {
        return;
    }
}
