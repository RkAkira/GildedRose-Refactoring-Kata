package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    @Test
    void shouldDecreaseBy2NormalItemQualityWhenSellInisPassed(){
        Item[] items = new Item[]{
                new Item("foo", 0, 15)};

//        NormalItem normalItem = new NormalItem("foo", 0, 15);
//        normalItem.updateQuality();


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

    @Test
    void testIsANormalItem_True(){
        Item[] items = new Item[]{
            new Item("foo", 10, 2)};

        GildedRose app = new GildedRose(items);

        assertTrue(app.isANormalItem(app.items[0]), "Incorrect : it is not a normal Item");
    }

//    @Test
//    void testIsANormalItem_False(){
//        Item[] items = new Item[]{
//            new Item("Aged Brie", 5,3),
//            new Item("Sulfuras, Hand of Ragnaros", 0,10),
//            new Item("Backstage passes to a TAFKAL80ETC concert", 10,5)};
//
//        GildedRose app = new GildedRose(items);
//
//        assertFalse(app.isANormalItem(app.items[0]), "Incorrect : it is a special Item");
//        assertFalse(app.isANormalItem(app.items[1]), "Incorrect : it is a special Item");
//        assertFalse(app.isANormalItem(app.items[2]), "Incorrect : it is a special Item");
//    }

    @Test
    void testSpecialItemRefining(){
        Item[] items = new Item[]{
            new Item("Aged Brie", 5,3),
            new Item("Sulfuras, Hand of Ragnaros", 0,10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10,5),
            new Item("Backstage passes to a TAFKAL80ETC concert", 3,4),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0,13)};

        GildedRose app = new GildedRose(items);
        app.specialItemRefining(app.items[0]);
        app.specialItemRefining(app.items[1]);
        app.specialItemRefining(app.items[2]);
        app.specialItemRefining(app.items[3]);
        app.specialItemRefining(app.items[4]);

        assertEquals(4, app.items[0].quality, "Incorrect quality for a the Aged Brie Item");
        assertEquals(10, app.items[1].quality, "Incorrect quality for the Sulfura Item");
        assertEquals(7, app.items[2].quality, "Incorrect quality for the Backstage Item");
        assertEquals(7, app.items[3].quality, "Incorrect quality for the Backstage Item");
        assertEquals(0, app.items[4].quality, "Incorrect quality for the Backstage passed Item");
    }

    @Test
    void testManageTimePassing(){
        Item[] items = new Item[]{
            new Item("foo", 10, 2),
            new Item("Aged Brie", 5,3),
            new Item("Sulfuras, Hand of Ragnaros", 0,10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10,5)};

        GildedRose app = new GildedRose(items);
        app.manageTimePassing(items[0]);
        app.manageTimePassing(items[1]);
        app.manageTimePassing(items[2]);
        app.manageTimePassing(items[3]);

        assertEquals(9,app.items[0].sellIn, "Incorrect sellIn for a normal Item");
        assertEquals(4, app.items[1].sellIn, "Incorrect sellIn for a the Aged Brie Item");
        assertEquals(0, app.items[2].sellIn, "Incorrect sellIn for the Sulfura Item");
        assertEquals(9, app.items[3].sellIn, "Incorrect sellIn for the Backstage passes Item");



    }


}
