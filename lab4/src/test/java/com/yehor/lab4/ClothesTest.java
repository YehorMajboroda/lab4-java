package com.yehor.lab4;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ClothesTest {

    @Test
    void shouldThrowExceptionWhenInvalidPrice() {

        Clothes c = new Clothes(
                "Tshirt",
                Size.M,
                Color.RED,
                25,
                "Nike",
                10
        );

        assertThrows(IllegalArgumentException.class, () -> {
            c.setPrice(-10);
        });
    }

    @Test
    void shouldThrowExceptionWhenInvalidConstructor() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Clothes(
                    "",
                    Size.M,
                    Color.BLACK,
                    -5,
                    "",
                    -1
            );
        });
    }
}