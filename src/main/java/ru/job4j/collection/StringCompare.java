package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            int character = Character.compare(left.charAt(i), right.charAt(i));
            if (character != 0) {
                return character;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}


