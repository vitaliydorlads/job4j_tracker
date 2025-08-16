package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] k1 = left.split("/", 2);
        String[] k2 = right.split("/", 2);
        int deck = Comparator.<String>naturalOrder().reversed().compare(k1[0], k2[0]);
        if (deck != 0) {
            return deck;
        }
        return Comparator.<String>naturalOrder().compare(left, right);
    }

}
