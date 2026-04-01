package com.yehor.lab4;

import java.util.Objects;

public class Clothes {
    private String name;
    private String size;
    private String color;
    private double price;

    public Clothes(String name, String size, String color, double price) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public String getName() { return name; }
    public String getSize() { return size; }
    public String getColor() { return color; }
    public double getPrice() { return price; }

    public void setName(String name) { this.name = name; }
    public void setSize(String size) { this.size = size; }
    public void setColor(String color) { this.color = color; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Clothes{" +
               "name='" + name + '\'' +
               ", size='" + size + '\'' +
               ", color='" + color + '\'' +
               ", price=" + price +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clothes)) return false;
        Clothes clothes = (Clothes) o;
        return Double.compare(clothes.price, price) == 0 &&
               Objects.equals(name, clothes.name) &&
               Objects.equals(size, clothes.size) &&
               Objects.equals(color, clothes.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, color, price);
    }
}