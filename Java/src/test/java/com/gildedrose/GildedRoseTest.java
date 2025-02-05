package com.gildedrose;

import java.util.ArrayList;
import java.util.List;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void testItemQualityEvolvingAccordingly(){
        Item[] items = new Item[]{
            new Item("foo", 10, 2),
            new Item("Aged Brie", 5,3),
            new Item("Sulfuras, Hand of Ragnaros", 0,10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10,5),
            new Item("Backstage passes to a TAFKAL80ETC concert", 3,4)};


        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(1,app.items[0].quality, "Incorrect quality for a normal Item");
        assertEquals(4, app.items[1].quality, "Incorrect quality for a the Aged Brie Item");
        assertEquals(10, app.items[2].quality, "Incorrect quality for the Sulfura Item");
        assertEquals(7, app.items[3].quality, "Incorrect quality for the Backstage passes Item");
        assertEquals(7, app.items[4].quality, "Incorrect quality for the Backstage passes Item");
    }

    @Test
    void testItemSellInEvolvingAccordingly(){
        Item[] items = new Item[]{
            new Item("foo", 10, 2),
            new Item("Aged Brie", 5,3),
            new Item("Sulfuras, Hand of Ragnaros", 0,10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10,5)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9,app.items[0].sellIn, "Incorrect sellIn for a normal Item");
        assertEquals(4, app.items[1].sellIn, "Incorrect sellIn for a the Aged Brie Item");
        assertEquals(0, app.items[2].sellIn, "Incorrect sellIn for the Sulfura Item");
        assertEquals(9, app.items[3].sellIn, "Incorrect sellIn for the Backstage passes Item");
    }

    @Test
    void testItemQualityAfterSellInPassed(){
        Item[] items = new Item[]{
            new Item("foo", 0, 15),
            new Item("Aged Brie", 0,10),
            new Item("Sulfuras, Hand of Ragnaros", 0,10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0,4)};


        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(13,app.items[0].quality, "Incorrect quality for a normal Item");
        assertEquals(12, app.items[1].quality, "Incorrect quality for a the Aged Brie Item");
        assertEquals(10, app.items[2].quality, "Incorrect quality for the Sulfura Item");
        assertEquals(0, app.items[3].quality, "Incorrect quality for the Backstage Item");
    }

    @Test
    void testItemQualityNeverNegative(){
        Item[] items = new Item[]{
            new Item("foo", 10, 0)};


        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9,app.items[0].sellIn, "Incorrect sellIn for a normal Item");
        assertFalse(app.items[0].quality<0, "The quality fro a normal item is negative");
    }

    @Test
    void testItemQualityNeverOver50(){
        Item[] items = new Item[]{
            new Item("foo", 10, 50)};


        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9,app.items[0].sellIn, "Incorrect sellIn for a normal Item");
        assertFalse(app.items[0].quality>50, "The quality for a normal item is over 50");
    }

    @Test
    void testSpecialItemRefining(){
        Item[] items = new Item[]{
            new Item("Aged Brie", 5,3)};

        GildedRose app = new GildedRose(items);
        app.specialItemRefining(items[0]);

        assertEquals(4, app.items[0].quality, "Incorrect quality for a the Aged Brie Item");
    }


}
