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
            manageTimePassing(item);
            updateItemQuality(item);
        }
    }

    public void updateItemQuality(Item item) {
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros" -> {
                SulfurasItem sulfurasItem = new SulfurasItem(item);
                sulfurasItem.updateQuality();
            }
            case "Backstage passes to a TAFKAL80ETC concert" -> {
                BackStagePassItem backStagePassItem = new BackStagePassItem(item);
                backStagePassItem.updateQuality();
                break;
            }
            case "Aged Brie" -> {
                AgedBrieItem agedBrieItem = new AgedBrieItem(item);
                agedBrieItem.updateQuality();
                break;
            }
            default -> {
                NormalItem normalItem = new NormalItem(item);
                normalItem.updateQuality();
                break;
            }
        }
    }

    public void manageTimePassing(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn -= 1;
    }
}
