package com.yehor.lab4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, "UTF-8");

        ArrayList<Clothes> list = new ArrayList<>();

        FileLoader.load("input.txt", list);

        while (true) {

            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1  Додати Clothes");
            System.out.println("2  Додати Pants");
            System.out.println("3  Додати Shirts");
            System.out.println("4  Додати Jacket");
            System.out.println("5  Додати Shoes");
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

                    switch (choice) {

                        case 1:
                            list.add(new Clothes(name, size, color, price, brand, quantity));
                            break;

                        case 2:
                            System.out.print("Тип (jeans/sport): ");
                            String type = scanner.nextLine();
                            list.add(new Pants(name, size, color, price, brand, quantity, type));
                            break;

                        case 3:
                            System.out.print("Рукав (long/short): ");
                            String sleeve = scanner.nextLine();
                            list.add(new Shirts(name, size, color, price, brand, quantity, sleeve));
                            break;

                        case 4:
                            System.out.print("Є капюшон (true/false): ");
                            boolean hood = Boolean.parseBoolean(scanner.nextLine());
                            list.add(new Jacket(name, size, color, price, brand, quantity, hood));
                            break;

                        case 5:
                            System.out.print("Розмір взуття: ");
                            int shoeSize = Integer.parseInt(scanner.nextLine());
                            list.add(new Shoes(name, size, color, price, brand, quantity, shoeSize));
                            break;
                    }

                    System.out.println(" Додано!");
                }

                else if (choice == 6) {

                    if (list.isEmpty()) {
                        System.out.println("Список порожній!");
                    } else {
                        for (Clothes c : list) {
                            System.out.println(c);
                        }
                    }
                }

                else if (choice == 0) {


                    FileSaver.save("input.txt", list);

                    System.out.println(" Дані збережено. Вихід...");
                    break;
                }

                else {
                    System.out.println("Невірний вибір!");
                }

            } catch (Exception e) {
                System.out.println(" Помилка: " + e.getMessage());
            }
        }

        scanner.close();
    }
}