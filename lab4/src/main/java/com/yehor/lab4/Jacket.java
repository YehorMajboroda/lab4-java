package com.yehor.lab4;

public class Jacket extends Clothes { // 8

    private boolean hasHood; // 8

    public Jacket(String name, Size size, Color color,
                  double price, String brand, int quantity,
                  boolean hasHood) {

        super(name, size, color, price, brand, quantity);
        this.hasHood = hasHood;
    }

    @Override
    public String toString() { // 8
        return "Jacket{" +
                "hasHood=" + hasHood +
                "} " + super.toString();
    }
}