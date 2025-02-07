package com.gildedrose;

import com.gildedrose.Items.NormalItem;

import java.util.List;

public class GildedRose {
    public List<NormalItem> items;

    public GildedRose(List<NormalItem> items) {
        this.items = items;
    }

    public void updateQuality() {
        this.items.forEach(item -> {
            item.manageTimePassing();
            item.updateQuality();
        });
    }
}
