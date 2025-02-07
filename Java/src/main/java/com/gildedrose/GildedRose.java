package com.gildedrose;

import com.gildedrose.Items.AgedBrieItem;
import com.gildedrose.Items.BackStagePassItem;
import com.gildedrose.Items.NormalItem;
import com.gildedrose.Items.SulfurasItem;

public class GildedRose {
    public Item[] items;


    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            NormalItem normalItem = castToNormalItem(item);
            normalItem.manageTimePassing();
            normalItem.updateQuality();
        }
    }


    public NormalItem castToNormalItem(Item item) {
        NormalItem normalItem;
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros" -> {
                normalItem = new SulfurasItem(item);;
            }
            case "Backstage passes to a TAFKAL80ETC concert" -> {
                normalItem = new BackStagePassItem(item);
            }
            case "Aged Brie" -> {
                normalItem = new AgedBrieItem(item);
            }
            default -> {
                normalItem = new NormalItem(item);
            }
        }
        return  normalItem;
    }
}
