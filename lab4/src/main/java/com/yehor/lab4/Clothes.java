package com.yehor.lab4;

public abstract class Clothes implements Comparable<Clothes> {

    private String name; // назва
    private Size size; // розмір
    private Color color; // колір
    private double price; // ціна
    private String brand; // бренд
    private int quantity; // кількість

    public Clothes(String name, Size size, Color color,
                   double price, String brand, int quantity) { // конструктор

        setName(name);
        setSize(size);
        setColor(color);
        setPrice(price);
        setBrand(brand);
        setQuantity(quantity);
    }

    public String getName() { // отримати назву
        return name;
    }

    public Size getSize() { // отримати розмір
        return size;
    }

    public Color getColor() { // отримати колір
        return color;
    }

    public double getPrice() { // отримати ціну
        return price;
    }

    public String getBrand() { // отримати бренд
        return brand;
    }

    public int getQuantity() { // отримати кількість
        return quantity;
    }

    public void setName(String name) { // встановити назву

        if (name == null || name.isBlank()) {
            throw new InvalidFieldValueException(
                    "Назва не може бути порожньою"
            );
        }

        this.name = name;
    }

    public void setSize(Size size) { // встановити розмір
        this.size = size;
    }

    public void setColor(Color color) { // встановити колір
        this.color = color;
    }

    public void setPrice(double price) { // встановити ціну

        if (price < 0) {
            throw new InvalidFieldValueException(
                    "Ціна не може бути від’ємною"
            );
        }

        this.price = price;
    }

    public void setBrand(String brand) { // встановити бренд

        if (brand == null || brand.isBlank()) {
            throw new InvalidFieldValueException(
                    "Бренд не може бути порожнім"
            );
        }

        this.brand = brand;
    }

    public void setQuantity(int quantity) { // встановити кількість

        if (quantity < 0) {
            throw new InvalidFieldValueException(
                    "Кількість не може бути від’ємною"
            );
        }

        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) { // порівняння об’єктів

        if (this == o) return true;

        if (!(o instanceof Clothes)) return false;

        Clothes c = (Clothes) o;

        return name.equalsIgnoreCase(c.name) &&
                brand.equalsIgnoreCase(c.brand) &&
                size == c.size &&
                color == c.color;
    }

    @Override
    public int compareTo(Clothes o) { // сортування
        return this.name.compareToIgnoreCase(o.name);
    }

    @Override
    public String toString() { // перетворення в рядок

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