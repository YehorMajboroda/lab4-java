package com.yehor.lab4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, "UTF-8");
        Wardrobe wardrobe = new Wardrobe();

        while (true) {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1  Додати Clothes");
            System.out.println("2  Додати Pants");
            System.out.println("3  Додати Shirts");
            System.out.println("4  Додати Jacket"); // 
            System.out.println("5  Додати Shoes");  // 8
            System.out.println("6  Показати всі");
            System.out.println("0  Вийти");

            System.out.print("Ваш вибір: ");
            int choice = Integer.parseInt(scanner.nextLine());

            try {

                if (choice >= 1 && choice <= 5) {

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

                    if (choice == 1) {
                        wardrobe.addClothes(new Clothes(name, size, color, price, brand, quantity));
                    }

                    else if (choice == 2) {
                        System.out.print("Тип (jeans/sport): ");
                        String type = scanner.nextLine();
                        wardrobe.addClothes(new Pants(name, size, color, price, brand, quantity, type));
                    }

                    else if (choice == 3) {
                        System.out.print("Рукав (long/short): ");
                        String sleeve = scanner.nextLine();
                        wardrobe.addClothes(new Shirts(name, size, color, price, brand, quantity, sleeve));
                    }

                    else if (choice == 4) { // 8
                        System.out.print("Є капюшон (true/false): ");
                        boolean hood = Boolean.parseBoolean(scanner.nextLine());
                        wardrobe.addClothes(new Jacket(name, size, color, price, brand, quantity, hood));
                    }

                    else if (choice == 5) { // 8
                        System.out.print("Розмір взуття (число): ");
                        int shoeSize = Integer.parseInt(scanner.nextLine());
                        wardrobe.addClothes(new Shoes(name, size, color, price, brand, quantity, shoeSize));
                    }

                    System.out.println("Додано!");
                }

                else if (choice == 6) {
                    wardrobe.showAll();
                }

                else if (choice == 0) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }

        scanner.close();
    }
}