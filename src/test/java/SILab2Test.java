import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void nullListTest(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 100));
        assertEquals("allItems list can't be null!", exception.getMessage());

    }

    @Test
    void returnTrueEmptyListTest(){
        List<Item> items = new ArrayList<>();
        assertTrue(SILab2.checkCart(items, 100));

    }
    @Test
    void returnTrueNullNameTest(){
        List<Item> items = new ArrayList<>();
        items.add(new Item(null, "12345", 100, 0.1f));
        assertTrue(SILab2.checkCart(items, 100));
    }

    @Test
    void returnTrueEmptyNameTest(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("", "12345", 100, 0.1f));
        assertTrue(SILab2.checkCart(items, 100));
    }
    @Test
    void nullCodeExceptionTest(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", null, 100, 0.1f));
        RuntimeException exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, 100));
        assertEquals("No barcode!", exception.getMessage());
    }
    @Test
    void InvalidCharacterInCodeExceptionTest(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "12a45", 100, 0.1f));
        RuntimeException exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, 100));
        assertEquals("Invalid character in item barcode!", exception.getMessage());
    }


    //    (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0')
    //     sum -=30

    //    false false false

    @Test
    void fffTrue(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "112345", 200, 0.0f));
        assertTrue(SILab2.checkCart(items, 340));
    }

    @Test
    void fffFalse(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "112345", 200, 0.0f));
        assertFalse(SILab2.checkCart(items, 150));
    }

    //    false false true

    @Test
    void fftTrue(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "012345", 200, 0.0f));
        assertTrue(SILab2.checkCart(items, 340));
    }

    @Test
    void fftFalse(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "012345", 200, 0.0f));
        assertFalse(SILab2.checkCart(items, 150));
    }

    //    false true false

    @Test
    void ftfTrue(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "112345", 200, 0.1f));
        assertTrue(SILab2.checkCart(items, 340));
    }

    @Test
    void ftfFalse(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "112345", 200, 0.1f));
        assertFalse(SILab2.checkCart(items, 15));
    }

    //    false true true

    @Test
    void fttTrue(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "012345", 200, 0.1f));
        assertTrue(SILab2.checkCart(items, 340));
    }

    @Test
    void fttFalse(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "012345", 200, 0.1f));
        assertFalse(SILab2.checkCart(items, 15));
    }

    //    true false false

    @Test
    void tffTrue(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "112345", 400, 0.0f));
        assertTrue(SILab2.checkCart(items, 400));
    }

    @Test
    void tffFalse(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "112345", 400, 0.0f));
        assertFalse(SILab2.checkCart(items, 300));
    }

    //    true false true

    @Test
    void tftTrue(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "012345", 400, 0.0f));
        assertTrue(SILab2.checkCart(items, 400));
    }

    @Test
    void tftFalse(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "012345", 400, 0.0f));
        assertFalse(SILab2.checkCart(items, 300));
    }

    //    true true false

    @Test
    void ttfTrue(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "112345", 400, 0.1f));
        assertTrue(SILab2.checkCart(items, 40));
    }

    @Test
    void ttfFalse(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "112345", 400, 0.1f));
        assertFalse(SILab2.checkCart(items, 30));
    }

    //    true true true

    @Test
    void tttTrue(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "012345", 500, 0.1f));
        assertTrue(SILab2.checkCart(items, 300));
    }

    @Test
    void tttFalse(){
        List<Item> items = new ArrayList<>();
        items.add(new Item("item1", "012345", 500, 0.1f));
        assertFalse(SILab2.checkCart(items, 10));
    }
}