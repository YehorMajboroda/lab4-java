package com.yehor.lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, "UTF-8");

        Store store = new Store();

        // тимчасовий список для читання з файлу
        List<Clothes> temp = new ArrayList<>();
        FileLoader.load("input.txt", temp);

        for (Clothes c : temp) {
            store.addNewClothes(c, c.getQuantity());
        }

        while (true) {

            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1  Додати Clothes (заборонено)");
            System.out.println("2  Додати Pants");
            System.out.println("3  Додати Shirts");
            System.out.println("4  Додати Jacket");
            System.out.println("5  Додати Shoes");
            System.out.println("6  Показати всі");
            System.out.println("7  Пошук об’єкта");
            System.out.println("8  Сортування (Comparator)");
            System.out.println("0  Вийти");

            System.out.print("Ваш вибір: ");
            int choice = Integer.parseInt(scanner.nextLine());

            try {

                if (choice == 1) {
                    System.out.println("Clothes — абстрактний клас. Створюйте Pants/Shirts/Jacket/Shoes");
                }

                else if (choice == 2 || choice == 3 || choice == 4 || choice == 5) {

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
                            String type = scanner.nextLine();
                            store.addNewClothes(
                                    new Pants(name, size, color, price, brand, quantity, type),
                                    quantity);
                            break;

                        case 3:
                            System.out.print("Рукав (long/short): ");
                            String sleeve = scanner.nextLine();
                            store.addNewClothes(
                                    new Shirts(name, size, color, price, brand, quantity, sleeve),
                                    quantity);
                            break;

                        case 4:
                            System.out.print("Є капюшон (true/false): ");
                            boolean hood = Boolean.parseBoolean(scanner.nextLine());
                            store.addNewClothes(
                                    new Jacket(name, size, color, price, brand, quantity, hood),
                                    quantity);
                            break;

                        case 5:
                            System.out.print("Розмір взуття: ");
                            int shoeSize = Integer.parseInt(scanner.nextLine());
                            store.addNewClothes(
                                    new Shoes(name, size, color, price, brand, quantity, shoeSize),
                                    quantity);
                            break;
                    }

                    System.out.println("Додано!");
                }

                else if (choice == 6) {
                    store.showAll();
                }

                else if (choice == 7) {

                    while (true) {

                        System.out.println("\n=== ПОШУК ===");
                        System.out.println("1 Пошук за брендом");
                        System.out.println("2 Пошук за кольором");
                        System.out.println("3 Пошук за розміром");
                        System.out.println("4 Пошук за типом");
                        System.out.println("0 Назад");

                        System.out.print("Ваш вибір: ");
                        int searchChoice = Integer.parseInt(scanner.nextLine());

                        if (searchChoice == 0) break;

                        switch (searchChoice) {

                            case 1:
                                System.out.print("Бренд: ");
                                store.byBrand(scanner.nextLine());
                                break;

                            case 2:
                                System.out.print("Колір: ");
                                store.byColor(Color.valueOf(scanner.nextLine().toUpperCase()));
                                break;

                            case 3:
                                System.out.print("Розмір: ");
                                store.bySize(Size.valueOf(scanner.nextLine().toUpperCase()));
                                break;

                            case 4:
                                System.out.print("Тип: ");
                                ClothesSearch.byType(store.getAll(), scanner.nextLine());
                                break;
                        }
                    }
                }

                //  ЛР14
                else if (choice == 8) {

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

                        Comparator<Clothes> comparator;

                        if (sortChoice == 1) {

                            comparator = new Comparator<Clothes>() {
                                @Override
                                public int compare(Clothes o1, Clothes o2) {
                                    return o1.getName().compareToIgnoreCase(o2.getName());
                                }
                            };

                        } else if (sortChoice == 2) {

                            comparator = new Comparator<Clothes>() {
                                @Override
                                public int compare(Clothes o1, Clothes o2) {
                                    return Double.compare(o1.getPrice(), o2.getPrice());
                                }
                            };

                        } else if (sortChoice == 3) {

                            comparator = new Comparator<Clothes>() {
                                @Override
                                public int compare(Clothes o1, Clothes o2) {
                                    return o1.getBrand().compareToIgnoreCase(o2.getBrand());
                                }
                            };

                        } else {
                            System.out.println("Невірний вибір!");
                            continue;
                        }

                        Collections.sort(sorted, comparator);

                        System.out.println("\n=== ВІДСОРТОВАНИЙ СПИСОК ===");
                        for (Clothes c : sorted) {
                            System.out.println(c);
                        }
                    }
                }

                else if (choice == 0) {

                    FileSaver.save("input.txt", store.getAll());
                    System.out.println("Дані збережено. Вихід...");
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