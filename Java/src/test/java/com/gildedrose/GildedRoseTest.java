package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    @Test
    void shouldDecreaseBy2NormalItemQualityWhenSellInisPassed(){
        Item[] items = new Item[]{
                new Item("foo", 0, 15)};


        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(13, app.items[0].quality, "Incorrect quality for a normal Item");}

    @Test
    void shouldIncreaseBy2AgedBrieQualityWhenSellInisPassed(){
        Item[] items = new Item[]{
                new Item("Aged Brie", 0,10)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(12, app.items[0].quality, "Incorrect quality for a the Aged Brie Item");
    }



    @Test
    void shouldNeverSetANormalItemNegativeQuality(){
        Item[] items = new Item[]{
                new Item("foo", 10, 0)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertFalse(app.items[0].quality<0, "The quality of a normal item is negative");
    }

    @Test
    void shouldIncreaseBy1AgedBrieQuality(){
        Item[] items = new Item[]{
                new Item("Aged Brie", 5,3)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(4, app.items[0].quality, "Incorrect quality for a the Aged Brie Item");
    }

    @Test
    void shouldNeverHaveQualityOver50(){
        Item[] items = new Item[]{
                new Item("Aged Brie", 2,50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 50,50)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertFalse(app.items[0].quality>50, "The quality of Aged Brie item is over 50");
        assertFalse(app.items[1].quality>50, "The quality of Backstage item is over 50");
    }

    @Test
    void shouldNotModifySulfurasQuality(){
        Item[] items = new Item[]{
                new Item("Sulfuras, Hand of Ragnaros", 0,10)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(10, app.items[0].quality, "Incorrect quality for the Sulfura Item");
    }

    @Test
    void shouldSetTo0BackstageQualityAfterSellInIsPassed(){
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0,4)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items[0].quality, "Incorrect quality for the Backstage Item");
    }

    @Test
    void shouldIncreaseBackstagePassQualityBy2(){
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 10,5),};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(7, app.items[0].quality, "Incorrect quality for the Backstage passes Item");
        ;

    }

    @Test
    void shouldIncreaseBackstagePassQualityBy3(){
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 3,4)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(7, app.items[0].quality, "Incorrect quality for the Backstage passes Item");
    }


}
