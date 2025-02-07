package com.gildedrose;

import com.gildedrose.Items.AgedBrieItem;
import com.gildedrose.Items.BackStagePassItem;
import com.gildedrose.Items.NormalItem;
import com.gildedrose.Items.SulfurasItem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class GildedRoseTest {

    @Test
    void shouldDecreaseBy2NormalItemQualityWhenSellInisPassed(){

        List<NormalItem> items = Collections.singletonList(new NormalItem(new Item("foo", 0, 15)));

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(13, app.items.get(0).getQuality(), "Incorrect quality for a normal Item");}

    @Test
    void shouldIncreaseBy2AgedBrieQualityWhenSellInisPassed(){
        List<NormalItem> items = Collections.singletonList(new AgedBrieItem(new Item("Aged Brie", 0,10)));

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(12, app.items.get(0).getQuality(), "Incorrect quality for a the Aged Brie Item");
    }



    @Test
    void shouldNeverSetANormalItemNegativeQuality(){

        List<NormalItem> items = Collections.singletonList(new NormalItem(new Item("foo", 10, 0)));


        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertFalse(app.items.get(0).getQuality()<0, "The quality of a normal item is negative");
    }

    @Test
    void shouldIncreaseBy1AgedBrieQuality(){

        List<NormalItem> items = Collections.singletonList(new AgedBrieItem(new Item("Aged Brie", 5,3)));

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(4, app.items.get(0).getQuality(), "Incorrect quality for a the Aged Brie Item");
    }

    @Test
    void shouldNeverHaveQualityOver50(){

        BackStagePassItem backStagePassItem = new BackStagePassItem(new Item("Backstage passes to a TAFKAL80ETC concert", 50,50));
        AgedBrieItem agedBrieItem = new AgedBrieItem( new Item("Aged Brie", 2,50));

        List<NormalItem> items = new ArrayList<>();

        items.add(backStagePassItem);
        items.add(agedBrieItem);



        GildedRose app = new GildedRose(items);
        app.updateQuality();
        boolean isQualityOver50 = app.items.stream().map(NormalItem::getQuality).anyMatch(q -> q>50);

        assertFalse(isQualityOver50, "The quality of Aged Brie item is over 50");
    }

    @Test
    void shouldNotModifySulfurasQuality(){

        List<NormalItem> items = Collections.singletonList(new SulfurasItem(new Item("Sulfuras, Hand of Ragnaros", 0,80)));

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(80, app.items.get(0).getQuality(), "Incorrect quality for the Sulfura Item");
    }

    @Test
    void shouldSetTo0BackstageQualityAfterSellInIsPassed(){

        List<NormalItem> items = Collections.singletonList(new BackStagePassItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0,4)));

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items.get(0).getQuality(), "Incorrect quality for the Backstage Item");
    }

    @Test
    void shouldIncreaseBackstagePassQualityBy2(){

        List<NormalItem> items = Collections.singletonList(new BackStagePassItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10,5)));

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(7, app.items.get(0).getQuality(), "Incorrect quality for the Backstage passes Item");
    }

    @Test
    void shouldIncreaseBackstagePassQualityBy3(){

        List<NormalItem> items = Collections.singletonList(new BackStagePassItem(new Item("Backstage passes to a TAFKAL80ETC concert", 3,4)));

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(7, app.items.get(0).getQuality(), "Incorrect quality for the Backstage passes Item");
    }


}
