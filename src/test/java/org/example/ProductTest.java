package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testValidProductCreation() {
        Product product = new Product("Laptop", 999.99);
        assertEquals("Laptop", product.getName());
        assertEquals(999.99, product.getPrice(), 0.0001);
    }

    @Test
    void testNegativePriceThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Product("Invalid", -1.0));
    }

    @Test
    void testZeroPriceIsValid() {
        Product product = new Product("Free Sample", 0.0);
        assertEquals("Free Sample", product.getName());
        assertEquals(0.0, product.getPrice(), 0.0001);
    }

    @Test
    void testNameCanBeEmpty() {
        Product product = new Product("", 10.0);
        assertEquals("", product.getName());
    }

    @Test
    void testGettersReturnCorrectValues() {
        Product product = new Product("Bottle", 2.5);
        assertAll(
                () -> assertEquals("Bottle", product.getName()),
                () -> assertEquals(2.5, product.getPrice(), 0.0001)
        );
    }
}
