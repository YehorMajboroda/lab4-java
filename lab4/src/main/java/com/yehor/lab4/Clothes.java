package com.yehor.lab4;

import java.util.UUID;

public abstract class Clothes implements Comparable<Clothes>, Identifiable {

    private UUID uuid;

    private String name;
    private Size size;
    private Color color;
    private double price;
    private String brand;
    private int quantity;

    public Clothes(String name, Size size, Color color,
                   double price, String brand, int quantity) {

        this.uuid = UUID.randomUUID(); // автоматичне створення UUID

        setName(name);
        setSize(size);
        setColor(color);
        setPrice(price);
        setBrand(brand);
        setQuantity(quantity);
    }

    // ===== UUID =====
    @Override
    public UUID getUuid() {
        return uuid;
    }

    // ===== getters =====
    public String getName() { return name; }
    public Size getSize() { return size; }
    public Color getColor() { return color; }
    public double getPrice() { return price; }
    public String getBrand() { return brand; }
    public int getQuantity() { return quantity; }

    // ===== setters =====
    public void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name empty");
        this.name = name;
    }

    public void setSize(Size size) {
        if (size == null)
            throw new IllegalArgumentException("Size null");
        this.size = size;
    }

    public void setColor(Color color) {
        if (color == null)
            throw new IllegalArgumentException("Color null");
        this.color = color;
    }

    public void setPrice(double price) {
        if (price <= 0)
            throw new IllegalArgumentException("Price <= 0");
        this.price = price;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.isEmpty())
            throw new IllegalArgumentException("Brand empty");
        this.brand = brand;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0)
            throw new IllegalArgumentException("Quantity < 0");
        this.quantity = quantity;
    }

    // ===== sorting =====
    @Override
    public int compareTo(Clothes o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    // ===== toString (UUID обов'язково видно) =====
    @Override
    public String toString() {
        return "Clothes{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", color=" + color +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}