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

    private static final String NORMAL_ITEM_NAME = "foo";
    private static final String AGED_BRIE_NAME = "Aged Brie";
    private static final String BACKSTAGE_PASS_NAME = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";

    @Test
    void shouldDecreaseBy2NormalItemQualityAfterExpirationDay() {

        List<NormalItem> items = Collections.singletonList(new NormalItem(new Item(NORMAL_ITEM_NAME, NormalItem.EXPIRATION_DAY, 15)));

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(13, app.items.get(0).getQuality(), "Incorrect quality for a normal Item");}

    @Test
    void shouldIncreaseBy2AgedBrieQualityAfterExpirationDay() {
        List<NormalItem> items = Collections.singletonList(new AgedBrieItem(new Item(AGED_BRIE_NAME, NormalItem.EXPIRATION_DAY, 10)));

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(12, app.items.get(0).getQuality(), "Incorrect quality for a the Aged Brie Item");
    }



    @Test
    void shouldNeverSetANormalItemNegativeQuality(){

        List<NormalItem> items = Collections.singletonList(new NormalItem(new Item(NORMAL_ITEM_NAME, 10, 0)));


        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertFalse(app.items.get(0).getQuality() < 0, "The quality of a normal item is negative");
    }

    @Test
    void shouldIncreaseBy1AgedBrieQuality(){

        List<NormalItem> items = Collections.singletonList(new AgedBrieItem(new Item(AGED_BRIE_NAME, 5, 3)));

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(4, app.items.get(0).getQuality(), "Incorrect quality for a the Aged Brie Item");
    }

    @Test
    void shouldBeAbleToSetQualityOverNormalItemMAX_QUALITY() {

        BackStagePassItem backStagePassItem = new BackStagePassItem(new Item(BACKSTAGE_PASS_NAME, 50, NormalItem.MAX_QUALITY));
        AgedBrieItem agedBrieItem = new AgedBrieItem(new Item(AGED_BRIE_NAME, 2, NormalItem.MAX_QUALITY));

        List<NormalItem> items = new ArrayList<>();

        items.add(backStagePassItem);
        items.add(agedBrieItem);

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        boolean isQualityOverNormalItemMAX_QUALITY = app.items.stream()
                .map(NormalItem::getQuality)
                .anyMatch(q -> q > NormalItem.MAX_QUALITY);

        assertFalse(isQualityOverNormalItemMAX_QUALITY, "The quality of Aged Brie item is over NormalItem.MAX_QUALITY");
    }

    @Test
    void shouldNotModifySulfurasQuality(){

        List<NormalItem> items = Collections.singletonList(new SulfurasItem(new Item(SULFURAS_NAME, NormalItem.EXPIRATION_DAY, SulfurasItem.SULFURAS_QUALITY)));

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(SulfurasItem.SULFURAS_QUALITY, app.items.get(0).getQuality(), "Incorrect quality for the Sulfura Item");
    }

    @Test
    void shouldSetTo0BackstageQualityAfterExpirationDay() {

        List<NormalItem> items = Collections.singletonList(new BackStagePassItem(new Item(BACKSTAGE_PASS_NAME, NormalItem.EXPIRATION_DAY, 4)));

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items.get(0).getQuality(), "Incorrect quality for the Backstage Item");
    }

    @Test
    void shouldIncreaseBackstagePassQualityBy2(){

        List<NormalItem> items = Collections.singletonList(new BackStagePassItem(new Item(BACKSTAGE_PASS_NAME, 10, 5)));

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(7, app.items.get(0).getQuality(), "Incorrect quality for the Backstage passes Item");
    }

    @Test
    void shouldIncreaseBackstagePassQualityBy3(){

        List<NormalItem> items = Collections.singletonList(new BackStagePassItem(new Item(BACKSTAGE_PASS_NAME, 3, 4)));

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(7, app.items.get(0).getQuality(), "Incorrect quality for the Backstage passes Item");
    }


}
