package com.techelevator.view;
import org.junit.Test;
import java.io.FileNotFoundException;
import static org.junit.Assert.*;

public class ProductTest {
    @Test
    public void testGetSetSlot() throws FileNotFoundException {
        Product product = new Product("A1", "Doritos", 3.05, "Chips");
        assertEquals("A1", product.getSlot());
        product.setSlot("B2");
        assertEquals("B2", product.getSlot());
    }

    @Test
    public void testGetSetName() throws FileNotFoundException {
        Product product = new Product("A1", "Doritos", 3.05, "Chips");
        assertEquals("Chips", product.getName());
        product.setName("Candy");
        assertEquals("Candy", product.getName());
    }

    @Test
    public void testGetSetPrice() throws FileNotFoundException {
        Product product = new Product("A1", "Doritos", 3.05, "Chips");
        assertEquals(1.50, product.getPrice(), 0.01);
        product.setPrice(2.00);
        assertEquals(2.00, product.getPrice(), 0.01);
    }

    @Test
    public void testGetSetType() throws FileNotFoundException {
        Product product = new Product("A1", "Doritos", 3.05, "Chips");
        assertEquals("Snack", product.getType());
        product.setType("Beverage");
        assertEquals("Beverage", product.getType());
    }

    @Test
    public void testGetSetQuantity() throws FileNotFoundException {
        Product product = new Product("A1", "Doritos", 3.05, "Chips");
        assertEquals(5, product.getQuantity());
        product.setQuantity(10);
        assertEquals(10, product.getQuantity());
    }
}
