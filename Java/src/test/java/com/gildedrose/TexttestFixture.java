package com.gildedrose;
import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.Items.AgedBrieItem;
import com.gildedrose.Items.BackStagePassItem;
import com.gildedrose.Items.NormalItem;
import com.gildedrose.Items.SulfurasItem;

import java.util.ArrayList;
import java.util.List;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        List<NormalItem> items = new ArrayList<NormalItem>();
        items.add(new NormalItem(new Item("+5 Dexterity Vest", 10, 20)));
        items.add(new NormalItem(new Item("Elixir of the Mongoose", 5, 7)));
        items.add(new AgedBrieItem(new Item("Aged Brie", 2, 0)));
        items.add(new SulfurasItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80)));
        items.add(new SulfurasItem(new Item("Sulfuras, Hand of Ragnaros", -1, 80)));
        items.add(new BackStagePassItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)));
        items.add(new BackStagePassItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)));
        items.add(new BackStagePassItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)));
        items.add(new NormalItem( new Item("Conjured Mana Cake", 3, 6)));


        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (NormalItem item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
