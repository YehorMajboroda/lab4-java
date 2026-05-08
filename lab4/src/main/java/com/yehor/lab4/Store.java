package com.yehor.lab4;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Clothes> list = new ArrayList<>(); // список одягу

    // ADD
    public void addNewClothes(Clothes newClothes, int quantity) { // додавання одягу

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
    public List<Clothes> getAll() { // отримати всі елементи
        return list;
    }

    public void showAll() { // вивід всіх елементів

        if (list.isEmpty()) {
            System.out.println("Список порожній");
            return;
        }

        for (Clothes c : list) {
            System.out.println(c);
        }
    }

    // ===== UPDATE (ЛР18) =====
    public boolean update(Clothes oldObj, Clothes newObj) { // оновлення об’єкта

        if (list.isEmpty()) {
            throw new ObjectNotFoundException("Список порожній"); // виняток якщо список пустий
        }

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).equals(oldObj)) {
                list.set(i, newObj);
                return true;
            }
        }

        throw new ObjectNotFoundException("Об'єкт не знайдено для оновлення"); // виняток якщо не знайдено
    }

    // ===== DELETE (ЛР18) =====
    public boolean delete(Clothes obj) { // видалення об’єкта

        if (list.isEmpty()) {
            throw new ObjectNotFoundException("Список порожній"); // виняток якщо пустий
        }

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).equals(obj)) {
                list.remove(i);
                return true;
            }
        }

        throw new ObjectNotFoundException("Об'єкт не знайдено для видалення"); // виняток якщо не знайдено
    }

    // ===== SEARCH BASE =====
    private boolean equalsClothes(Clothes c1, Clothes c2) { // порівняння одягу

        return c1.getName().equalsIgnoreCase(c2.getName()) &&
                c1.getBrand().equalsIgnoreCase(c2.getBrand()) &&
                c1.getSize() == c2.getSize() &&
                c1.getColor() == c2.getColor();
    }

    public void byBrand(String brand) { // пошук за брендом

        boolean found = false;

        for (Clothes c : list) {
            if (c.getBrand().equalsIgnoreCase(brand)) {
                System.out.println(c);
                found = true;
            }
        }

        if (!found) System.out.println("Нічого не знайдено");
    }

    public void byColor(Color color) { // пошук за кольором

        boolean found = false;

        for (Clothes c : list) {
            if (c.getColor() == color) {
                System.out.println(c);
                found = true;
            }
        }

        if (!found) System.out.println("Нічого не знайдено");
    }

    public void bySize(Size size) { // пошук за розміром

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