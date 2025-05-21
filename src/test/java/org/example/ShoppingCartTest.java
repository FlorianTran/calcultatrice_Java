package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    private ShoppingCart cart;
    private Product book;
    private Product pen;
    private Product notebook;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        book = new Product("Book", 12.5);
        pen = new Product("Pen", 1.5);
        notebook = new Product("Notebook", 3.0);
    }

    @Test
    void testEmptyCart() {
        assertEquals(0, cart.getItemCount());
        assertEquals(0.0, cart.getTotalPrice(), 0.0001);
        assertTrue(cart.getAllProducts().isEmpty());
    }

    @Test
    void testAddProduct() {
        cart.addProduct(book);
        assertEquals(1, cart.getItemCount());
        assertEquals(12.5, cart.getTotalPrice(), 0.0001);
        assertTrue(cart.containsProduct(book));
    }

    @Test
    void testAddMultipleProducts() {
        cart.addProduct(pen);
        cart.addProduct(notebook);
        assertEquals(2, cart.getItemCount());
        assertEquals(4.5, cart.getTotalPrice(), 0.0001);
    }

    @Test
    void testAddNullProduct() {
        assertThrows(IllegalArgumentException.class, () -> cart.addProduct(null));
    }

    @Test
    void testNegativePriceProduct() {
        assertThrows(IllegalArgumentException.class, () -> new Product("Faulty", -10));
    }

    @Test
    void testClearCart() {
        cart.addProduct(book);
        cart.addProduct(pen);
        cart.clearCart();
        assertEquals(0, cart.getItemCount());
        assertEquals(0.0, cart.getTotalPrice(), 0.0001);
        assertFalse(cart.containsProduct(book));
    }

    @Test
    void testRemoveProductExists() {
        cart.addProduct(pen);
        boolean removed = cart.removeProduct(pen);
        assertTrue(removed);
        assertEquals(0, cart.getItemCount());
    }

    @Test
    void testRemoveProductNotExists() {
        boolean removed = cart.removeProduct(pen);
        assertFalse(removed);
    }

    @Test
    void testContainsProduct() {
        cart.addProduct(notebook);
        assertTrue(cart.containsProduct(notebook));
    }

    @Test
    void testFindProductByNameExactMatch() {
        cart.addProduct(book);
        Product found = cart.findProductByName("Book");
        assertNotNull(found);
        assertEquals("Book", found.getName());
    }

    @Test
    void testFindProductByNameCaseInsensitive() {
        cart.addProduct(book);
        Product found = cart.findProductByName("bOoK");
        assertNotNull(found);
    }

    @Test
    void testFindProductByNameNotFound() {
        cart.addProduct(pen);
        Product found = cart.findProductByName("Notebook");
        assertNull(found);
    }

    @Test
    void testGetProductCountByName() {
        cart.addProduct(new Product("Pen", 1.0));
        cart.addProduct(new Product("Pen", 1.0));
        cart.addProduct(new Product("Notebook", 3.0));
        assertEquals(2, cart.getProductCount("Pen"));
        assertEquals(1, cart.getProductCount("Notebook"));
        assertEquals(0, cart.getProductCount("Book"));
    }

    @Test
    void testGetAllProductsReturnsCopy() {
        cart.addProduct(pen);
        List<Product> all = cart.getAllProducts();
        assertEquals(1, all.size());
        all.clear();
        assertEquals(1, cart.getItemCount());
    }
}
