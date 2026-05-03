package com.yehor.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

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
            System.out.println("7  Пошук (бренд/колір/розмір/тип)");
            System.out.println("8  Сортування (Lambda)");
            System.out.println("9  Пошук за UUID"); // +++ ЛР16
            System.out.println("0  Вийти");

            System.out.print("Ваш вибір: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Помилка вводу!");
                continue;
            }

            try {

                if (choice == 1) {
                    System.out.println("Clothes — базовий тип");
                }

                else if (choice >= 2 && choice <= 5) {

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
                            System.out.print("Капюшон (true/false): ");
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

                else if (choice == 6) {
                    store.showAll();
                }

                // ===== ПОШУКИ =====
                else if (choice == 7) {

                    System.out.println("\n=== ПОШУК ===");
                    System.out.println("1 Бренд");
                    System.out.println("2 Колір");
                    System.out.println("3 Розмір");
                    System.out.println("4 Тип");

                    int sc = Integer.parseInt(scanner.nextLine());

                    if (sc == 1) {
                        System.out.print("Бренд: ");
                        store.byBrand(scanner.nextLine());

                    } else if (sc == 2) {
                        System.out.print("Колір: ");
                        store.byColor(Color.valueOf(scanner.nextLine().toUpperCase()));

                    } else if (sc == 3) {
                        System.out.print("Розмір: ");
                        store.bySize(Size.valueOf(scanner.nextLine().toUpperCase()));

                    } else if (sc == 4) {
                        System.out.print("Тип: ");
                        ClothesSearch.byType(store.getAll(), scanner.nextLine());
                    }
                }

                // ===== СОРТУВАННЯ =====
                else if (choice == 8) {

                    List<Clothes> sorted = new ArrayList<>(store.getAll());

                    System.out.println("\n1 - Name");
                    System.out.println("2 - Price");
                    System.out.println("3 - Brand");

                    int sortChoice = Integer.parseInt(scanner.nextLine());

                    switch (sortChoice) {

                        case 1:
                            sorted.sort((a, b) ->
                                    a.getName().compareToIgnoreCase(b.getName()));
                            break;

                        case 2:
                            sorted.sort((a, b) ->
                                    Double.compare(a.getPrice(), b.getPrice()));
                            break;

                        case 3:
                            sorted.sort((a, b) ->
                                    a.getBrand().compareToIgnoreCase(b.getBrand()));
                            break;

                        default:
                            System.out.println("Невірно!");
                            continue;
                    }

                    for (Clothes c : sorted) {
                        System.out.println(c);
                    }
                }

                // UUID ПОШУК 
                else if (choice == 9) {

                    System.out.print("Введіть UUID: ");

                    try {
                        UUID uuid = UUID.fromString(scanner.nextLine());

                        Clothes found = store.findByUuid(uuid);

                        if (found != null) {
                            System.out.println("\nЗНАЙДЕНО:");
                            System.out.println(found);
                        } else {
                            System.out.println("Не знайдено!");
                        }

                    } catch (IllegalArgumentException e) {
                        System.out.println("Некоректний UUID формат!");
                    }
                }

                else if (choice == 0) {
                    FileSaver.save("input.txt", store.getAll());
                    System.out.println("Збережено. Вихід...");
                    break;
                }

                else {
                    System.out.println("Невірний вибір!");
                }

            } catch (Exception e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }

        scanner.close();
    }
}