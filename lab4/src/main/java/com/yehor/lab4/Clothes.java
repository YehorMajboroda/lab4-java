package com.yehor.lab4;

public abstract class Clothes implements Comparable<Clothes> {

    private String name;
    private Size size;
    private Color color;
    private double price;
    private String brand;
    private int quantity;

    public Clothes(String name, Size size, Color color,
                   double price, String brand, int quantity) {

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
        this.name = name;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // ===== ЛР17 ВАЖЛИВО =====
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Clothes)) return false;

        Clothes c = (Clothes) o;

        return name.equalsIgnoreCase(c.name) &&
                brand.equalsIgnoreCase(c.brand) &&
                size == c.size &&
                color == c.color;
    }

    @Override
    public int compareTo(Clothes o) {
        return this.name.compareToIgnoreCase(o.name);
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
}