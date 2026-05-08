package com.yehor.lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) { // головний метод програми

        Scanner scanner = new Scanner(System.in, "UTF-8"); // ввід з клавіатури
        Store store = new Store(); // створення магазину (контейнеру)

        // Завантаження з файлу
        List<Clothes> temp = new ArrayList<>(); // тимчасовий список
        FileLoader.load("input.txt", temp); // читання з файлу

        for (Clothes c : temp) { // перенесення у Store
            store.addNewClothes(c, c.getQuantity());
        }

        while (true) { // головний цикл меню

            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1  Додати Clothes (заблоковано)");
            System.out.println("2  Додати Pants");
            System.out.println("3  Додати Shirts");
            System.out.println("4  Додати Jacket");
            System.out.println("5  Додати Shoes");
            System.out.println("6  Показати всі");
            System.out.println("7  Пошук об’єкта");
            System.out.println("8  Сортування (Lambda)");
            System.out.println("9  Модифікувати об’єкт");
            System.out.println("10 Видалити об’єкт");
            System.out.println("0  Вийти");

            System.out.print("Ваш вибір: ");
            int choice = Integer.parseInt(scanner.nextLine()); // вибір користувача

            try {

                if (choice == 1) { // заборонений базовий тип
                    System.out.println("Clothes — базовий тип. Використайте Shirts/Pants/Jacket/Shoes");
                    continue;
                }

                // ===== ADD =====
                if (choice >= 2 && choice <= 5) { // додавання одягу

                    System.out.print("Назва: ");
                    String name = scanner.nextLine();

                    System.out.print("Розмір (XS,S,M,L,XL): ");
                    Size size = Size.valueOf(scanner.nextLine().toUpperCase());

                    System.out.print("Колір (RED,BLUE,BLACK,WHITE,GREEN): ");
                    Color color = Color.valueOf(scanner.nextLine().toUpperCase());

                    System.out.print("Ціна: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    System.out.print("Бренд: ");
                    String brand = scanner.nextLine();

                    System.out.print("Кількість: ");
                    int quantity = Integer.parseInt(scanner.nextLine());

                    switch (choice) {

                        case 2:
                            System.out.print("Тип (jeans/sport): ");
                            store.addNewClothes(
                                    new Pants(name, size, color, price, brand, quantity,
                                            scanner.nextLine()),
                                    quantity);
                            break;

                        case 3:
                            System.out.print("Рукав (long/short): ");
                            store.addNewClothes(
                                    new Shirts(name, size, color, price, brand, quantity,
                                            scanner.nextLine()),
                                    quantity);
                            break;

                        case 4:
                            System.out.print("Є капюшон (true/false): ");
                            store.addNewClothes(
                                    new Jacket(name, size, color, price, brand, quantity,
                                            Boolean.parseBoolean(scanner.nextLine())),
                                    quantity);
                            break;

                        case 5:
                            System.out.print("Розмір взуття: ");
                            store.addNewClothes(
                                    new Shoes(name, size, color, price, brand, quantity,
                                            Integer.parseInt(scanner.nextLine())),
                                    quantity);
                            break;
                    }

                    System.out.println("Додано!");
                }

                // ===== SHOW =====
                else if (choice == 6) { // показати всі
                    store.showAll();
                }

                // ===== SEARCH =====
                else if (choice == 7) { // пошук

                    System.out.println("\n=== ПОШУК ===");
                    System.out.println("1 Бренд");
                    System.out.println("2 Колір");
                    System.out.println("3 Розмір");
                    System.out.println("4 Тип");

                    int sc = Integer.parseInt(scanner.nextLine());

                    if (sc == 1) {
                        System.out.print("Введіть бренд: ");
                        store.byBrand(scanner.nextLine());

                    } else if (sc == 2) {
                        System.out.print("Введіть колір: ");
                        store.byColor(Color.valueOf(scanner.nextLine().toUpperCase()));

                    } else if (sc == 3) {
                        System.out.print("Введіть розмір: ");
                        store.bySize(Size.valueOf(scanner.nextLine().toUpperCase()));

                    } else if (sc == 4) {
                        System.out.print("Введіть тип: ");
                        ClothesSearch.byType(store.getAll(), scanner.nextLine());
                    }
                }

                // ===== SORT =====
                else if (choice == 8) { // сортування

                    while (true) {

                        System.out.println("\n=== СОРТУВАННЯ ===");
                        System.out.println("1. За назвою");
                        System.out.println("2. За ціною");
                        System.out.println("3. За брендом");
                        System.out.println("0. Назад");

                        System.out.print("Ваш вибір: ");
                        int sortChoice = Integer.parseInt(scanner.nextLine());

                        if (sortChoice == 0) break;

                        List<Clothes> sorted = new ArrayList<>(store.getAll());

                        if (sorted.isEmpty()) {
                            System.out.println("Список порожній");
                            continue;
                        }

                        switch (sortChoice) {

                            case 1:
                                Collections.sort(sorted,
                                        (o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
                                break;

                            case 2:
                                Collections.sort(sorted,
                                        (o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice()));
                                break;

                            case 3:
                                Collections.sort(sorted,
                                        (o1, o2) -> o1.getBrand().compareToIgnoreCase(o2.getBrand()));
                                break;
                        }

                        for (Clothes c : sorted) {
                            System.out.println(c);
                        }
                    }
                }

                // ===== UPDATE =====
                else if (choice == 9) { // оновлення

                    try {

                        System.out.print("Введіть назву: ");
                        String name = scanner.nextLine();

                        Clothes old = null;

                        for (Clothes c : store.getAll()) {
                            if (c.getName().equalsIgnoreCase(name)) {
                                old = c;
                                break;
                            }
                        }

                        if (old == null) {
                            System.out.println("Не знайдено!");
                            continue;
                        }

                        System.out.print("Нова ціна: ");
                        double price = Double.parseDouble(scanner.nextLine());

                        Clothes updated = null;

                        if (old instanceof Pants) {
                            Pants p = (Pants) old;
                            updated = new Pants(p.getName(), p.getSize(), p.getColor(),
                                    price, p.getBrand(), p.getQuantity(), p.getType());
                        }
                        else if (old instanceof Shirts) {
                            Shirts s = (Shirts) old;
                            updated = new Shirts(s.getName(), s.getSize(), s.getColor(),
                                    price, s.getBrand(), s.getQuantity(), s.getSleeveType());
                        }
                        else if (old instanceof Jacket) {
                            Jacket j = (Jacket) old;
                            updated = new Jacket(j.getName(), j.getSize(), j.getColor(),
                                    price, j.getBrand(), j.getQuantity(), j.isHasHood());
                        }
                        else if (old instanceof Shoes) {
                            Shoes sh = (Shoes) old;
                            updated = new Shoes(sh.getName(), sh.getSize(), sh.getColor(),
                                    price, sh.getBrand(), sh.getQuantity(), sh.getShoeSize());
                        }

                        store.update(old, updated);
                        System.out.println("Оновлено!");

                    } catch (ObjectNotFoundException e) {
                        System.out.println("Помилка: " + e.getMessage());
                    }
                }

                // ===== DELETE =====
                else if (choice == 10) { // видалення

                    try {

                        System.out.print("Введіть назву: ");
                        String name = scanner.nextLine();

                        Clothes target = null;

                        for (Clothes c : store.getAll()) {
                            if (c.getName().equalsIgnoreCase(name)) {
                                target = c;
                                break;
                            }
                        }

                        if (target == null) {
                            System.out.println("Не знайдено!");
                            continue;
                        }

                        System.out.print("Підтвердити (yes/no): ");
                        String confirm = scanner.nextLine();

                        if (confirm.equalsIgnoreCase("yes")) {
                            store.delete(target);
                            System.out.println("Видалено!");
                        }

                    } catch (ObjectNotFoundException e) {
                        System.out.println("Помилка: " + e.getMessage());
                    }
                }

                else if (choice == 0) { // вихід
                    FileSaver.save("input.txt", store.getAll());
                    System.out.println("Збережено. Вихід...");
                    break;
                }

                else {
                    System.out.println("Невірний вибір!");
                }

            } catch (Exception e) { // загальна помилка
                System.out.println("Помилка: " + e.getMessage());
            }
        }

        scanner.close(); // закриття scanner
    }
}