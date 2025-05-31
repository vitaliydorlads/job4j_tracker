package ru.job4j.item;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemDescByNameTest {
    @Test
    void whenSortByNameDescending() {
        List<Item> items = new ArrayList<>(List.of(
                new Item("Ivan"),
                new Item("Vasiliy"),
                new Item("Kristina")
        ));
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = List.of(new Item("Vasiliy"),
                new Item("Kristina"),
                new Item("Ivan"));
        assertThat(items).isEqualTo(expected);
    }
}