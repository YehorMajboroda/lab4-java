package com.yehor.lab4;

import java.io.*;
import java.util.List;

public class FileSaver {

    public static void save(String fileName, List<Clothes> list) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            for (Clothes c : list) {

                if (c instanceof Pants) {
                    Pants p = (Pants) c;
                    bw.write("Pants;" + base(c) + ";" + p.getType());
                }

                else if (c instanceof Shirts) {
                    Shirts s = (Shirts) c;
                    bw.write("Shirts;" + base(c) + ";" + s.getSleeveType());
                }

                else if (c instanceof Jacket) {
                    Jacket j = (Jacket) c;
                    bw.write("Jacket;" + base(c) + ";" + j.isHasHood());
                }

                else if (c instanceof Shoes) {
                    Shoes sh = (Shoes) c;
                    bw.write("Shoes;" + base(c) + ";" + sh.getShoeSize());
                }

                else {
                    bw.write("Clothes;" + base(c));
                }

                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println(" Помилка запису!");
        }
    }

    private static String base(Clothes c) {
        return c.getName() + ";" +
                c.getSize() + ";" +
                c.getColor() + ";" +
                c.getPrice() + ";" +
                c.getBrand() + ";" +
                c.getQuantity();
    }
}