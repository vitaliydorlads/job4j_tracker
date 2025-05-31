package ru.job4j.item;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    void whenSortByNameAscending() {
        List<Item> items = new ArrayList<>(List.of(
                new Item("Ivan"),
                new Item("Vasiliy"),
                new Item("Kristina")
        ));
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = List.of(new Item("Ivan"),
                new Item("Kristina"),
                new Item("Vasiliy"));
        assertThat(items).isEqualTo(expected);
    }
}