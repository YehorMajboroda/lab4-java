package com.yehor.lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, "UTF-8");
        Store store = new Store();

        // Завантаження з файлу
        List<Clothes> temp = new ArrayList<>();
        FileLoader.load("input.txt", temp);

        for (Clothes c : temp) {
            store.addNewClothes(c, c.getQuantity());
        }

        while (true) {

            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1  Додати Clothes (заблоковано)");
            System.out.println("2  Додати Pants");
            System.out.println("3  Додати Shirts");
            System.out.println("4  Додати Jacket");
            System.out.println("5  Додати Shoes");
            System.out.println("6  Показати всі");
            System.out.println("7  Пошук");
            System.out.println("8  Сортування");
            System.out.println("9  Модифікувати");
            System.out.println("10 Видалити");
            System.out.println("0  Вийти");

            System.out.print("Ваш вибір: ");
            int choice = Integer.parseInt(scanner.nextLine());

            try {

                // ===== ADD =====
                if (choice >= 2 && choice <= 5) {

                    System.out.print("Назва: ");
                    String name = scanner.nextLine();

                    System.out.print("Розмір: ");
                    Size size = Size.valueOf(scanner.nextLine().toUpperCase());

                    System.out.print("Колір: ");
                    Color color = Color.valueOf(scanner.nextLine().toUpperCase());

                    System.out.print("Ціна: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    System.out.print("Бренд: ");
                    String brand = scanner.nextLine();

                    System.out.print("Кількість: ");
                    int quantity = Integer.parseInt(scanner.nextLine());

                    switch (choice) {

                        case 2:
                            System.out.print("Тип: ");
                            store.addNewClothes(
                                    new Pants(name, size, color, price, brand, quantity,
                                            scanner.nextLine()),
                                    quantity);
                            break;

                        case 3:
                            System.out.print("Рукав: ");
                            store.addNewClothes(
                                    new Shirts(name, size, color, price, brand, quantity,
                                            scanner.nextLine()),
                                    quantity);
                            break;

                        case 4:
                            System.out.print("Капюшон: ");
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
                else if (choice == 6) {
                    store.showAll();
                }

                // ===== SEARCH =====
                else if (choice == 7) {

                    System.out.println("1 Бренд");
                    System.out.println("2 Колір");
                    System.out.println("3 Розмір");

                    int sc = Integer.parseInt(scanner.nextLine());

                    if (sc == 1) {
                        store.byBrand(scanner.nextLine());
                    } else if (sc == 2) {
                        store.byColor(Color.valueOf(scanner.nextLine().toUpperCase()));
                    } else if (sc == 3) {
                        store.bySize(Size.valueOf(scanner.nextLine().toUpperCase()));
                    }
                }

                // ===== SORT =====
                else if (choice == 8) {

                    List<Clothes> sorted = new ArrayList<>(store.getAll());

                    System.out.println("1 Name");
                    System.out.println("2 Price");
                    System.out.println("3 Brand");

                    int s = Integer.parseInt(scanner.nextLine());

                    if (s == 1) {
                        Collections.sort(sorted,
                                (a, b) -> a.getName().compareToIgnoreCase(b.getName()));
                    } else if (s == 2) {
                        Collections.sort(sorted,
                                (a, b) -> Double.compare(a.getPrice(), b.getPrice()));
                    } else if (s == 3) {
                        Collections.sort(sorted,
                                (a, b) -> a.getBrand().compareToIgnoreCase(b.getBrand()));
                    }

                    for (Clothes c : sorted) {
                        System.out.println(c);
                    }
                }

                // ===== UPDATE =====
                else if (choice == 9) {

                    System.out.print("Назва: ");
                    String name = scanner.nextLine();

                    Clothes old = null;

                    for (Clothes c : store.getAll()) {
                        if (c.getName().equalsIgnoreCase(name)) {
                            old = c;
                            break;
                        }
                    }

                    System.out.print("Нова ціна: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    Clothes updated = old;

                    if (old instanceof Pants) {
                        Pants p = (Pants) old;
                        updated = new Pants(p.getName(), p.getSize(), p.getColor(),
                                price, p.getBrand(), p.getQuantity(), p.getType());
                    }

                    if (old instanceof Shirts) {
                        Shirts s = (Shirts) old;
                        updated = new Shirts(s.getName(), s.getSize(), s.getColor(),
                                price, s.getBrand(), s.getQuantity(), s.getSleeveType());
                    }

                    if (old instanceof Jacket) {
                        Jacket j = (Jacket) old;
                        updated = new Jacket(j.getName(), j.getSize(), j.getColor(),
                                price, j.getBrand(), j.getQuantity(), j.isHasHood());
                    }

                    if (old instanceof Shoes) {
                        Shoes sh = (Shoes) old;
                        updated = new Shoes(sh.getName(), sh.getSize(), sh.getColor(),
                                price, sh.getBrand(), sh.getQuantity(), sh.getShoeSize());
                    }

                    store.update(old, updated);
                    System.out.println("Оновлено!");
                }

                // ===== DELETE =====
                else if (choice == 10) {

                    System.out.print("Назва: ");
                    String name = scanner.nextLine();

                    Clothes target = null;

                    for (Clothes c : store.getAll()) {
                        if (c.getName().equalsIgnoreCase(name)) {
                            target = c;
                            break;
                        }
                    }

                    System.out.print("yes/no: ");
                    if (scanner.nextLine().equalsIgnoreCase("yes")) {
                        store.delete(target);
                        System.out.println("Видалено!");
                    }
                }

                else if (choice == 0) {
                    FileSaver.save("input.txt", store.getAll());
                    break;
                }

                else {
                    System.out.println("Невірний вибір!");
                }

            } catch (ObjectNotFoundException e) {
                System.out.println("Помилка: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Загальна помилка: " + e.getMessage());
            }
        }

        scanner.close();
    }
}