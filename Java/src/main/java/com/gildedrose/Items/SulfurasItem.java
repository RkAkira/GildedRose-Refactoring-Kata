package com.gildedrose.Items;

import com.gildedrose.Item;

public class SulfurasItem extends NormalItem {
    public SulfurasItem(Item item) {
        super(item);
        this.setQuality(80);
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
