package com.yehor.lab4;

public class Pants extends Clothes {

    private String type;

    public Pants(String name, Size size, Color color,
                 double price, String brand, int quantity, String type) {
        super(name, size, color, price, brand, quantity);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Pants{" +
                "type='" + type + '\'' +
                "} " + super.toString();
    }
}