package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream()
                .filter(predicate)
                .map(stu -> new Student(stu.getScore(), stu.getSurname()))
                .collect(Collectors.toList());
    }
}
