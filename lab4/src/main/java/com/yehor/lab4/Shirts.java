package com.yehor.lab4;

public class Shirts extends Clothes {

    private String sleeveType;

    public Shirts(String name, Size size, Color color,
                  double price, String brand, int quantity, String sleeveType) {
        super(name, size, color, price, brand, quantity);
        this.sleeveType = sleeveType;
    }

    public String getSleeveType() {
        return sleeveType;
    }

    @Override
    public String toString() {
        return "Shirts{" +
                "sleeveType='" + sleeveType + '\'' +
                "} " + super.toString();
    }
}