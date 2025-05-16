package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {
    public Set<String> extractNumber(List<Task> tasks) {
        Set<String> res = new HashSet<>();
        for (Task index : tasks) {
            res.add(index.getNumber());
        }
        return res;
    }
}
