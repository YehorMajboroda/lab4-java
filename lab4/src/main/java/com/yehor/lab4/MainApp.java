package com.yehor.lab4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainApp extends Application {

    private Store store = new Store();

    @Override
    public void start(Stage stage) {

        // ===== INPUT FIELDS =====
        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        TextField brandField = new TextField();
        brandField.setPromptText("Brand");

        TextField uuidField = new TextField();
        uuidField.setPromptText("UUID");

        TextField sizeField = new TextField();
        sizeField.setPromptText("Size (XS,S,M,L,XL)");

        TextField colorField = new TextField();
        colorField.setPromptText("Color (RED,BLUE,BLACK,WHITE,GREEN)");

        TextField priceField = new TextField();
        priceField.setPromptText("Price");

        TextField quantityField = new TextField();
        quantityField.setPromptText("Quantity");

        TextField extraField = new TextField();
        extraField.setPromptText("Extra (type/sleeve/shoeSize/hood)");

        // ===== OUTPUT =====
        TextArea output = new TextArea();
        output.setPrefHeight(300);

        // ===== BUTTONS =====
        Button addShirt = new Button("Add Shirt");
        Button addPants = new Button("Add Pants");
        Button addJacket = new Button("Add Jacket");
        Button addShoes = new Button("Add Shoes");

        Button showAll = new Button("Show All");

        Button searchUuidBtn = new Button("Search UUID");

        // ===== ADD SHIRT =====
        addShirt.setOnAction(e -> {
            try {
                Clothes c = new Shirts(
                        nameField.getText(),
                        Size.valueOf(sizeField.getText().toUpperCase()),
                        Color.valueOf(colorField.getText().toUpperCase()),
                        Double.parseDouble(priceField.getText()),
                        brandField.getText(),
                        Integer.parseInt(quantityField.getText()),
                        extraField.getText()
                );

                store.addNewClothes(c, c.getQuantity());
                output.appendText("ADDED SHIRT: " + c + "\n");

            } catch (Exception ex) {
                output.appendText("ERROR ADD SHIRT\n");
            }
        });

        // ===== ADD PANTS =====
        addPants.setOnAction(e -> {
            try {
                Clothes c = new Pants(
                        nameField.getText(),
                        Size.valueOf(sizeField.getText().toUpperCase()),
                        Color.valueOf(colorField.getText().toUpperCase()),
                        Double.parseDouble(priceField.getText()),
                        brandField.getText(),
                        Integer.parseInt(quantityField.getText()),
                        extraField.getText()
                );

                store.addNewClothes(c, c.getQuantity());
                output.appendText("ADDED PANTS: " + c + "\n");

            } catch (Exception ex) {
                output.appendText("ERROR ADD PANTS\n");
            }
        });

        // ===== ADD JACKET =====
        addJacket.setOnAction(e -> {
            try {
                Clothes c = new Jacket(
                        nameField.getText(),
                        Size.valueOf(sizeField.getText().toUpperCase()),
                        Color.valueOf(colorField.getText().toUpperCase()),
                        Double.parseDouble(priceField.getText()),
                        brandField.getText(),
                        Integer.parseInt(quantityField.getText()),
                        Boolean.parseBoolean(extraField.getText())
                );

                store.addNewClothes(c, c.getQuantity());
                output.appendText("ADDED JACKET: " + c + "\n");

            } catch (Exception ex) {
                output.appendText("ERROR ADD JACKET\n");
            }
        });

        // ===== ADD SHOES =====
        addShoes.setOnAction(e -> {
            try {
                Clothes c = new Shoes(
                        nameField.getText(),
                        Size.valueOf(sizeField.getText().toUpperCase()),
                        Color.valueOf(colorField.getText().toUpperCase()),
                        Double.parseDouble(priceField.getText()),
                        brandField.getText(),
                        Integer.parseInt(quantityField.getText()),
                        Integer.parseInt(extraField.getText())
                );

                store.addNewClothes(c, c.getQuantity());
                output.appendText("ADDED SHOES: " + c + "\n");

            } catch (Exception ex) {
                output.appendText("ERROR ADD SHOES\n");
            }
        });

        // ===== SHOW ALL =====
        showAll.setOnAction(e -> {
            for (Clothes c : store.getAll()) {
                output.appendText(c + "\n");
            }
        });

        // ===== SEARCH UUID =====
        searchUuidBtn.setOnAction(e -> {
            try {
                UUID uuid = UUID.fromString(uuidField.getText());

                Clothes found = store.findByUuid(uuid);

                if (found != null) {
                    output.appendText("\nFOUND:\n" + found + "\n");
                } else {
                    output.appendText("NOT FOUND\n");
                }

            } catch (Exception ex) {
                output.appendText("INVALID UUID\n");
            }
        });

        // ===== LAYOUT 
        VBox root = new VBox(
                new Label("Name"), nameField,
                new Label("Brand"), brandField,
                new Label("Size"), sizeField,
                new Label("Color"), colorField,
                new Label("Price"), priceField,
                new Label("Quantity"), quantityField,
                new Label("Extra"), extraField,

                addShirt,
                addPants,
                addJacket,
                addShoes,

                new Separator(),
                showAll,

                new Separator(),
                new Label("UUID Search"), uuidField,
                searchUuidBtn,

                new Separator(),
                output
        );

        Scene scene = new Scene(root, 600, 700);

        stage.setTitle("Clothes Store GUI (UUID)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}