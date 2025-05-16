package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean result = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String index : origin) {
            check.add(index);
        }
        for (String index : text) {
            if (!check.contains(index)) {
                result = false;
            }
        }
        return result;
    }
}
