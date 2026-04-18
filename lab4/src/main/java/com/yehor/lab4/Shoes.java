package com.yehor.lab4;

public class Shoes extends Clothes { // 8

    private int shoeSize; // 8

    public Shoes(String name, Size size, Color color,
                 double price, String brand, int quantity,
                 int shoeSize) {

        super(name, size, color, price, brand, quantity);
        this.shoeSize = shoeSize;
    }

    @Override
    public String toString() { // 8
        return "Shoes{" +
                "shoeSize=" + shoeSize +
                "} " + super.toString();
    }
}