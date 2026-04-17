package com.yehor.lab4;

import java.util.Objects;

/**
 * Клас Clothes описує одяг
 */
public class Clothes {

    private String name;
    private Size size;
    private Color color;
    private double price;
    private String brand;
    private int quantity;

    // 7  ВИДАЛЕНО static count

    public Clothes(String name, Size size, Color color, double price, String brand, int quantity) {
        setName(name);
        setSize(size);
        setColor(color);
        setPrice(price);
        setBrand(brand);
        setQuantity(quantity);
    }

    public String getName() { return name; }
    public Size getSize() { return size; }
    public Color getColor() { return color; }
    public double getPrice() { return price; }
    public String getBrand() { return brand; }
    public int getQuantity() { return quantity; }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setSize(Size size) {
        if (size == null) {
            throw new IllegalArgumentException("Size cannot be null");
        }
        this.size = size;
    }

    public void setColor(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("Color cannot be null");
        }
        this.color = color;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be > 0");
        }
        this.price = price;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be empty");
        }
        this.brand = brand;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", color=" + color +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clothes)) return false;
        Clothes clothes = (Clothes) o;
        return Double.compare(clothes.price, price) == 0 &&
                quantity == clothes.quantity &&
                Objects.equals(name, clothes.name) &&
                size == clothes.size &&
                color == clothes.color &&
                Objects.equals(brand, clothes.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, color, price, brand, quantity);
    }
}