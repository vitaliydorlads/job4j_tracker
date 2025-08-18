package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] k1 = left.split("/", 2);
        String[] k2 = right.split("/", 2);
        int res = k2[0].compareTo(k1[0]);
        return res != 0 ? res : left.compareTo(right);
    }
}
