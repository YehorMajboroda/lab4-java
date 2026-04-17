package com.yehor.lab4;

public class Shirts extends Clothes { // 7

    private String sleeveType; // 7 (long / short)

    public Shirts(String name, Size size, Color color, double price, String brand, int quantity, String sleeveType) {
        super(name, size, color, price, brand, quantity);
        this.sleeveType = sleeveType;
    }

    @Override
    public String toString() { // 7 поліморфізм
        return "Shirts{" +
                "sleeveType='" + sleeveType + '\'' +
                "} " + super.toString();
    }
}