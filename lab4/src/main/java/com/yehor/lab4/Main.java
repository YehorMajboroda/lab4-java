package com.yehor.lab4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in, "UTF-8");
        ArrayList<Clothes> list = new ArrayList<>();

        while (true) {
            System.out.println("\n МЕНЮ ");
            System.out.println("1  Додати річ");
            System.out.println("2  Показати всі речі");
            System.out.println("0  Вийти");

            System.out.print("Ваш вибір: ");
            String input = scanner.nextLine();

            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Помилка: введіть число!");
                continue;
            }

            if (choice == 1) {
                try {
                    System.out.print("Назва: ");
                    String name = scanner.nextLine();

                    System.out.print("Розмір: ");
                    String size = scanner.nextLine();

                    System.out.print("Колір: ");
                    String color = scanner.nextLine();

                    System.out.print("Ціна: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    System.out.print("Бренд: ");
                    String brand = scanner.nextLine();

                    System.out.print("Кількість: ");
                    int quantity = Integer.parseInt(scanner.nextLine());

                    Clothes c = new Clothes(name, size, color, price, brand, quantity);
                    list.add(c);

                    System.out.println(" Річ додано!");

                } catch (NumberFormatException e) {
                    System.out.println("Помилка: введіть правильне число!");
                } catch (IllegalArgumentException e) {
                    System.out.println("Помилка: " + e.getMessage());
                }
            }

            else if (choice == 2) {
                if (list.isEmpty()) {
                    System.out.println("Список порожній!");
                } else {
                    System.out.println("\nСписок речей:");
                    for (Clothes c : list) {
                        System.out.println(c);
                    }
                }
            }

            else if (choice == 0) {
                System.out.println("Вихід");
                break;
            }

            else {
                System.out.println("Невірний вибір!");
            }
        }

        scanner.close();
    }
}