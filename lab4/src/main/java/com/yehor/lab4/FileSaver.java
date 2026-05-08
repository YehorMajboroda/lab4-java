package com.yehor.lab4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileSaver {

    public static void save(String fileName, List<Clothes> list) { // збереження у файл

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            for (Clothes c : list) {

                if (c instanceof Pants) { // запис Pants
                    Pants p = (Pants) c;
                    bw.write("Pants;" + base(c) + ";" + p.getType());
                }

                else if (c instanceof Shirts) { // запис Shirts
                    Shirts s = (Shirts) c;
                    bw.write("Shirts;" + base(c) + ";" + s.getSleeveType());
                }

                else if (c instanceof Jacket) { // запис Jacket
                    Jacket j = (Jacket) c;
                    bw.write("Jacket;" + base(c) + ";" + j.isHasHood());
                }

                else if (c instanceof Shoes) { // запис Shoes
                    Shoes sh = (Shoes) c;
                    bw.write("Shoes;" + base(c) + ";" + sh.getShoeSize());
                }

                else { // запис базового типу
                    bw.write("Clothes;" + base(c));
                }

                bw.newLine(); // новий рядок
            }

        } catch (IOException e) { // обробка помилки запису
            System.out.println(" Помилка запису!");
        }
    }

    private static String base(Clothes c) { // базові поля об’єкта

        return c.getName() + ";" +
                c.getSize() + ";" +
                c.getColor() + ";" +
                c.getPrice() + ";" +
                c.getBrand() + ";" +
                c.getQuantity();
    }
}