package com.yehor.lab4;

import java.util.List;

public class ClothesSearch {


    public static void byBrand(List<Clothes> list, String brand) {

        boolean found = false;

        for (Clothes c : list) {
            if (c.getBrand().equalsIgnoreCase(brand)) {
                System.out.println(c);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Нічого не знайдено!");
        }
    }


    public static void byColor(List<Clothes> list, Color color) {

        boolean found = false;

        for (Clothes c : list) {
            if (c.getColor() == color) {
                System.out.println(c);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Нічого не знайдено!");
        }
    }


    public static void bySize(List<Clothes> list, Size size) {

        boolean found = false;

        for (Clothes c : list) {
            if (c.getSize() == size) {
                System.out.println(c);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Нічого не знайдено!");
        }
    }


    public static void byType(List<Clothes> list, String type) {

        boolean found = false;

        for (Clothes c : list) {

            switch (type.toLowerCase()) {

                case "clothes":
                    if (c.getClass() == Clothes.class) {
                        System.out.println(c);
                        found = true;
                    }
                    break;

                case "pants":
                    if (c instanceof Pants) {
                        System.out.println(c);
                        found = true;
                    }
                    break;

                case "shirts":
                    if (c instanceof Shirts) {
                        System.out.println(c);
                        found = true;
                    }
                    break;

                case "jacket":
                    if (c instanceof Jacket) {
                        System.out.println(c);
                        found = true;
                    }
                    break;

                case "shoes":
                    if (c instanceof Shoes) {
                        System.out.println(c);
                        found = true;
                    }
                    break;
            }
        }

        if (!found) {
            System.out.println("Нічого не знайдено!");//
        }
    }
}