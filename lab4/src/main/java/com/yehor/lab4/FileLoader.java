package com.yehor.lab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileLoader {

    public static void load(String fileName, List<Clothes> list) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {

                try {
                    String[] p = line.split(";");

                    String type = p[0];

                    String name = p[1];
                    Size size = Size.valueOf(p[2]);
                    Color color = Color.valueOf(p[3]);
                    double price = Double.parseDouble(p[4]);
                    String brand = p[5];
                    int quantity = Integer.parseInt(p[6]);

                    switch (type) {


                        case "Clothes":
                            list.add(new Shirts(name, size, color, price, brand, quantity, "default")); // +++
                            break;

                        case "Pants":
                            list.add(new Pants(name, size, color, price, brand, quantity, p[7]));
                            break;

                        case "Shirts":
                            list.add(new Shirts(name, size, color, price, brand, quantity, p[7]));
                            break;

                        case "Jacket":
                            list.add(new Jacket(name, size, color, price, brand, quantity,
                                    Boolean.parseBoolean(p[7])));
                            break;

                        case "Shoes":
                            list.add(new Shoes(name, size, color, price, brand, quantity,
                                    Integer.parseInt(p[7])));
                            break;

                        default:
                            System.out.println("Невідомий тип: " + type);
                    }

                } catch (Exception e) {
                    System.out.println("Помилка рядка: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Помилка читання файлу!");
        }
    }
}/