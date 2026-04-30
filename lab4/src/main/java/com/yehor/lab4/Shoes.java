package com.yehor.lab4;

public class Shoes extends Clothes {

    private int shoeSize;

    public Shoes(String name, Size size, Color color,
                 double price, String brand, int quantity,
                 int shoeSize) {
        super(name, size, color, price, brand, quantity);
        this.shoeSize = shoeSize;
    }

    public int getShoeSize() {
        return shoeSize;
    }

    @Override
    public String toString() {
        return "Shoes{" +
                "shoeSize=" + shoeSize +
                "} " + super.toString();
    }
}