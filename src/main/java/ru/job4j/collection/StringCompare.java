package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int sizeLeft = left.length();
        int sizeRing = right.length();
        int integer = Integer.compare(sizeLeft, sizeRing);
        int min = Math.min(sizeLeft, sizeRing);
        for (int i = 0; i < min; i++) {
            int character = Character.compare(left.charAt(i), right.charAt(i));
            if (character != 0) {
                return character;
            }
        }
        if (integer != 0) {
            return integer;
        }
        return 0;
    }
}


