package com.techelevator.view;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class ProductListTest  {
    Product product;

    @BeforeEach
    public void setUp() throws FileNotFoundException {
        Product product = new Product("A1", "Doritos", 3.05, "Chips");
    }


    @Test
     public void testGetQuantity() {

        Assert.assertEquals(5 , product.getQuantity());

    }

    @Test
    void testGetSlot() {
        Assert.assertEquals("A1", product.getSlot());
    }

    @Test
    void testGetName() {
        Assert.assertEquals("Chips", product.getName());
    }

    @Test
    void testGetPrice() {
        Assert.assertEquals(1.50, product.getPrice(), 0.01);
    }

    @Test
    void testGetType() {
    Assert.assertEquals("Snack",product.getType());
    }
}