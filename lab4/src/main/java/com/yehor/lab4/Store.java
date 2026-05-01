package com.yehor.lab4;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Clothes> list = new ArrayList<>();

    // ===== ДОДАВАННЯ =====
    public void addNewClothes(Clothes newClothes, int quantity) {

        for (Clothes c : list) {

            if (equalsClothes(c, newClothes)) {
                c.setQuantity(c.getQuantity() + quantity);
                return;
            }
        }

        newClothes.setQuantity(quantity);
        list.add(newClothes);
    }

    private boolean equalsClothes(Clothes c1, Clothes c2) {

        return c1.getName().equalsIgnoreCase(c2.getName()) &&
               c1.getBrand().equalsIgnoreCase(c2.getBrand()) &&
               c1.getSize() == c2.getSize() &&
               c1.getColor() == c2.getColor();
    }

    // ===== ВИВІД =====
    public void showAll() {
        if (list.isEmpty()) {
            System.out.println("Список порожній");
            return;
        }

        for (Clothes c : list) {
            System.out.println(c);
        }
    }

    public List<Clothes> getAll() {
        return list;
    }

    // ===== ПОШУКИ =====
    public void byBrand(String brand) {

        boolean found = false;

        for (Clothes c : list) {
            if (c.getBrand().equalsIgnoreCase(brand)) {
                System.out.println(c);
                found = true;
            }
        }

        if (!found) System.out.println("Нічого не знайдено");
    }

    public void byColor(Color color) {

        boolean found = false;

        for (Clothes c : list) {
            if (c.getColor() == color) {
                System.out.println(c);
                found = true;
            }
        }

        if (!found) System.out.println("Нічого не знайдено");
    }

    public void bySize(Size size) {

        boolean found = false;

        for (Clothes c : list) {
            if (c.getSize() == size) {
                System.out.println(c);
                found = true;
            }
        }

        if (!found) System.out.println("Нічого не знайдено");
    }

    // ===== ПРАВИЛЬНИЙ ПОШУК ПО ТИПУ =====
    public void byType(String type) {

        boolean found = false;

        for (Clothes c : list) {

            if (type.equalsIgnoreCase("clothes") && c.getClass() == Clothes.class) {
                System.out.println(c);
                found = true;
            }

            else if (type.equalsIgnoreCase("pants") && c instanceof Pants) {
                System.out.println(c);
                found = true;
            }

            else if (type.equalsIgnoreCase("shirts") && c instanceof Shirts) {
                System.out.println(c);
                found = true;
            }

            else if (type.equalsIgnoreCase("jacket") && c instanceof Jacket) {
                System.out.println(c);
                found = true;
            }

            else if (type.equalsIgnoreCase("shoes") && c instanceof Shoes) {
                System.out.println(c);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Нічого не знайдено");
        }
    }
}