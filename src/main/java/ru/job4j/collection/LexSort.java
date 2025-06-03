package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] strLeft = left.split("\\D+");
        String[] strRight = right.split("\\D+");
        int min = Math.min(strLeft.length, strRight.length);
        for (int i = 0; i < min; i++) {
            int num1 = Integer.parseInt(strLeft[i]);
            int num2 = Integer.parseInt(strRight[i]);
            int integer = Integer.compare(num1, num2);
            if (integer != 0) {
                return integer;
            }
        }
        return 0;
    }
}
