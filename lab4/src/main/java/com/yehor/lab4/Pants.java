package com.yehor.lab4;

public class Pants extends Clothes { // 7

    private String type; // 7 (наприклад: jeans, sport)

    public Pants(String name, Size size, Color color, double price, String brand, int quantity, String type) {
        super(name, size, color, price, brand, quantity);
        this.type = type;
    }

    @Override
    public String toString() { // 7 поліморфізмм
        return "Pants{" +
                "type='" + type + '\'' +
                "} " + super.toString();
    }
}