package com.yehor.lab4;

import java.util.ArrayList;
import java.util.List;


public class Wardrobe { // +++

    private List<Clothes> clothesList = new ArrayList<>(); // +++

    public void addClothes(Clothes c) { // +++
        clothesList.add(c);
    }

    public void showAll() { // +++
        if (clothesList.isEmpty()) {
            System.out.println("Список порожній!");
        } else {
            for (Clothes c : clothesList) {
                System.out.println(c);
            }
        }
    }
}