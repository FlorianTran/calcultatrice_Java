package org.example;

import java.util.ArrayList;
import java.util.List;
public class ShoppingCart {
    private List<Product> items;
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        items.add(product);
    }
    public double getTotalPrice() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }
    public int getItemCount() {
        return items.size();
    }
    public void clearCart() {
        items.clear();
    }

    public boolean removeProduct(Product product) {
        return items.remove(product);
    }

    public boolean containsProduct(Product product) {
        return items.contains(product);
    }

    public Product findProductByName(String name) {
        return items.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public int getProductCount(String name) {
        return (int) items.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .count();
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(items);
    }
}