package com.yehor.lab4;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість речей: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // очищення буфера

        Clothes[] clothesArray = new Clothes[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nВведіть дані для речі #" + (i + 1));
            System.out.print("Назва: ");
            String name = scanner.nextLine();

            System.out.print("Розмір: ");
            String size = scanner.nextLine();

            System.out.print("Колір: ");
            String color = scanner.nextLine();

            System.out.print("Ціна: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // очищення буфера

            clothesArray[i] = new Clothes(name, size, color, price);
        }

        System.out.println("\nСписок речей:");
        for (Clothes c : clothesArray) {
            System.out.println(c);
        }

        scanner.close();
    }
}