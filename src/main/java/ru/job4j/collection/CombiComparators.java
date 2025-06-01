package ru.job4j.collection;

import java.util.Comparator;

public class CombiComparators {
    public static final Comparator<Job> COMBIDES = new JobDescByName()
            .thenComparing(new JobDescByPriority());
    public static final Comparator<Job> COMBIASC = new JobAscByName()
            .thenComparing(new JobAscByPriority());
}
