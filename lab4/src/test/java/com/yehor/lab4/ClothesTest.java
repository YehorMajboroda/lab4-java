package com.yehor.lab4;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ClothesTest {

    @Test
    void shouldThrowExceptionWhenInvalidPrice() {

        Clothes c = new Shirts(
                "Tshirt",
                Size.M,
                Color.RED,
                25,
                "Nike",
                10,
                "long"
        );

        assertThrows(IllegalArgumentException.class, () -> {
            c.setPrice(-10);
        });
    }

    @Test
    void shouldThrowExceptionWhenInvalidConstructor() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Shirts(
                    "",
                    Size.M,
                    Color.BLACK,
                    -5,
                    "",
                    -1,
                    "long"
            );
        });
    }
}