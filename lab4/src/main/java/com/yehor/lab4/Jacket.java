package com.yehor.lab4;

public class Jacket extends Clothes {

    private boolean hasHood;

    public Jacket(String name, Size size, Color color,
                  double price, String brand, int quantity,
                  boolean hasHood) {
        super(name, size, color, price, brand, quantity);
        this.hasHood = hasHood;
    }

    public boolean isHasHood() {
        return hasHood;
    }

    @Override
    public String toString() {
        return "Jacket{" +
                "hasHood=" + hasHood +
                "} " + super.toString();
    }
}//