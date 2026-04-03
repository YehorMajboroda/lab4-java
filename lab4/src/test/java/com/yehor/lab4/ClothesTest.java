package com.yehor.lab4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClothesTest {

    @Test
    void shouldThrowExceptionWhenInvalidPrice() {
        Clothes c = new Clothes("Shirt", "M", "Black", 100, "Nike", 5);

        assertThrows(IllegalArgumentException.class, () -> {
            c.setPrice(-10);
        });
    }

    @Test
    void shouldThrowExceptionWhenInvalidConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Clothes("", "M", "Black", -5, "", -1);
        });
    }
}