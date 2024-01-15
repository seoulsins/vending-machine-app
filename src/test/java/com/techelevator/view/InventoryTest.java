package com.techelevator.view;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class InventoryTest {
    @Test
    public void testAddItemToInventory() {
        Inventory inventory = new Inventory();
        inventory.addItemToInventory("Dr.pepper");
        inventory.addItemToInventory("Trix Yogurt");
        List<String> items = inventory.displayInventoryCounts();
        assertEquals(2, items.size());
        assertTrue(items.contains("Dr.pepper"));
        assertTrue(items.contains("Trix Yogurt"));
    }

    @Test
    public void testDisplayEmptyInventory() {
        Inventory inventory = new Inventory();
        List<String> items = inventory.displayInventoryCounts();
        assertEquals(0, items.size());
    }
}
