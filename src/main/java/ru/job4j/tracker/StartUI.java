package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI extends Item {
    public static void main(String[] args) {
        Item item = new Item();
        String format = item.getCreated().format(DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss"));
        System.out.println(format);
    }
}

