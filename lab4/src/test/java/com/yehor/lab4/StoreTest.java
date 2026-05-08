package com.yehor.lab4;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class StoreTest {

    @Test
    void shouldThrowExceptionWhenDeleteNonExisting() {

        Store store = new Store();

        Clothes c = new Shirts(
                "Tshirt",
                Size.M,
                Color.RED,
                25,
                "Nike",
                10,
                "long"
        );

        assertThrows(ObjectNotFoundException.class, () -> {
            store.delete(c);
        });
    }

    //  НОВИЙ ОБОВ’ЯЗКОВИЙ ТЕСТ (update)
    @Test
    void shouldThrowExceptionWhenUpdateNonExisting() {

        Store store = new Store();

        Clothes old = new Pants(
                "Jeans",
                Size.M,
                Color.BLUE,
                50,
                "Levis",
                5,
                "sport"
        );

        Clothes updated = new Pants(
                "Jeans",
                Size.M,
                Color.BLUE,
                60,
                "Levis",
                5,
                "sport"
        );

        assertThrows(ObjectNotFoundException.class, () -> {
            store.update(old, updated);
        });
    }
}