package com.yehor.lab4;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Clothes> list = new ArrayList<>();

    // ===== ADD ====
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

    // ===== SHOW =====
    public List<Clothes> getAll() {
        return list;
    }

    public void showAll() {

        if (list.isEmpty()) {
            System.out.println("Список порожній");
            return;
        }

        for (Clothes c : list) {
            System.out.println(c);
        }
    }

    // ===== UPDATE (ЛР17) =====
    public boolean update(Clothes oldObj, Clothes newObj) {

        if (list.isEmpty()) {
            return false;
        }

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).equals(oldObj)) {
                list.set(i, newObj);
                return true;
            }
        }

        return false;
    }

    // ===== DELETE (ЛР17) =====
    public boolean delete(Clothes obj) {

        if (list.isEmpty()) {
            return false;
        }

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).equals(obj)) {
                list.remove(i);
                return true;
            }
        }

        return false;
    }

    // ===== SEARCH BASE =====
    private boolean equalsClothes(Clothes c1, Clothes c2) {

        return c1.getName().equalsIgnoreCase(c2.getName()) &&
                c1.getBrand().equalsIgnoreCase(c2.getBrand()) &&
                c1.getSize() == c2.getSize() &&
                c1.getColor() == c2.getColor();
    }

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
}