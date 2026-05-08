package com.yehor.lab4;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ClothesTest {

    @Test
    void shouldThrowExceptionWhenInvalidPrice() { // тест: неправильна ціна

        Clothes c = new Shirts(
                "Tshirt",
                Size.M,
                Color.RED,
                25,
                "Nike",
                10,
                "long"
        );

        assertThrows(InvalidFieldValueException.class, () -> { // перевірка винятку
            c.setPrice(-10);
        });
    }

    @Test
    void shouldThrowExceptionWhenInvalidConstructor() { // тест: некоректні дані в конструкторі

        assertThrows(InvalidFieldValueException.class, () -> { // очікуємо виняток
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