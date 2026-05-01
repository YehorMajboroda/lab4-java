package com.yehor.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, "UTF-8");

        Store store = new Store();
        DatabaseManager db = new DatabaseManager(args[0]);

        // ===== Завантаження з файлу =====
        List<Clothes> temp = new ArrayList<>();
        FileLoader.load("input.txt", temp);

        for (Clothes c : temp) {
            store.addNewClothes(c, c.getQuantity());
            db.insertClothes(c, c.getClass().getSimpleName());
        }

        while (true) {

            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1  Додати Clothes");
            System.out.println("2  Додати Pants");
            System.out.println("3  Додати Shirts");
            System.out.println("4  Додати Jacket");
            System.out.println("5  Додати Shoes");
            System.out.println("6  Показати всіх");
            System.out.println("7  Пошук");
            System.out.println("0  Вийти");

            System.out.print("Ваш вибір: ");
            int choice = Integer.parseInt(scanner.nextLine());

            try {

                if (choice >= 1 && choice <= 5) {

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

                    Clothes obj = null;
                    String type = "";

                    switch (choice) {

                        case 1:
                            obj = new Clothes(name, size, color, price, brand, quantity);
                            type = "Clothes";
                            break;

                        case 2:
                            System.out.print("Тип: (jeans/sport):");
                            String pantsType = scanner.nextLine();
                            obj = new Pants(name, size, color, price, brand, quantity, pantsType);
                            type = "Pants";
                            break;

                        case 3:
                            System.out.print("Рукав: (long/short): ");
                            String sleeve = scanner.nextLine();
                            obj = new Shirts(name, size, color, price, brand, quantity, sleeve);
                            type = "Shirts";
                            break;

                        case 4:
                            System.out.print("Капюшон: (true/false): ");
                            boolean hood = Boolean.parseBoolean(scanner.nextLine());
                            obj = new Jacket(name, size, color, price, brand, quantity, hood);
                            type = "Jacket";
                            break;

                        case 5:
                            System.out.print("Розмір взуття: ");
                            int shoeSize = Integer.parseInt(scanner.nextLine());
                            obj = new Shoes(name, size, color, price, brand, quantity, shoeSize);
                            type = "Shoes";
                            break;
                    }

                    store.addNewClothes(obj, quantity);
                    db.insertClothes(obj, type);

                    System.out.println("Додано + збережено в БД!");
                }

                else if (choice == 6) {
                    store.showAll();
                }

                else if (choice == 7) {

                    System.out.println("\n=== ПОШУК ===");
                    System.out.println("1 бренд");
                    System.out.println("2 колір");
                    System.out.println("3 розмір");
                    System.out.println("4 тип");
                    System.out.println("0 назад");

                    int s = Integer.parseInt(scanner.nextLine());

                    switch (s) {

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
                            store.byType(scanner.nextLine());
                            break;
                    }
                }

                else if (choice == 0) {

                    System.out.println("Вихід...");

  
                    FileSaver.save("input.txt", store.getAll());

                    db.close(); 
                    break;
                }

            } catch (Exception e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }

        scanner.close();
    }
}