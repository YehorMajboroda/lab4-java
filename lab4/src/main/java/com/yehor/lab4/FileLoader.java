package com.yehor.lab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileLoader {

    public static void load(String fileName, List<Clothes> list) { // завантаження з файлу

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {

                try {
                    String[] p = line.split(";");

                    String type = p[0]; // тип одягу

                    String name = p[1]; // назва
                    Size size = Size.valueOf(p[2]); // розмір
                    Color color = Color.valueOf(p[3]); // колір
                    double price = Double.parseDouble(p[4]); // ціна
                    String brand = p[5]; // бренд
                    int quantity = Integer.parseInt(p[6]); // кількість

                    switch (type) {

                        case "Clothes":
                            list.add(new Shirts(name, size, color,
                                    price, brand, quantity,
                                    "default"));
                            break;

                        case "Pants":
                            list.add(new Pants(name, size, color,
                                    price, brand, quantity,
                                    p[7]));
                            break;

                        case "Shirts":
                            list.add(new Shirts(name, size, color,
                                    price, brand, quantity,
                                    p[7]));
                            break;

                        case "Jacket":
                            list.add(new Jacket(name, size, color,
                                    price, brand, quantity,
                                    Boolean.parseBoolean(p[7])));
                            break;

                        case "Shoes":
                            list.add(new Shoes(name, size, color,
                                    price, brand, quantity,
                                    Integer.parseInt(p[7])));
                            break;

                        default:
                            System.out.println("Невідомий тип: " + type);
                    }

                } catch (Exception e) { // обробка помилок рядка
                    System.out.println("Помилка рядка: " + line);
                }
            }

        } catch (IOException e) { // обробка помилки читання файлу
            System.out.println("Помилка читання файлу!");
        }
    }
}