package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComparatorsTest {

    @Test
    void whenjobDescByName() {
        List<Job> jobs = new ArrayList<>(List.of(new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Finish the program", 2)));
        Collections.sort(jobs, new JobDescByName());
        List<Job> exp = List.of(new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Finish the program", 2));
        assertThat(jobs).isEqualTo(exp);
    }

    @Test
    void whenjobAscByName() {
        List<Job> jobs = new ArrayList<>(List.of(new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Finish the program", 2)));
        Collections.sort(jobs, new JobAscByName());
        List<Job> exp = List.of(new Job("Finish the program", 2),
                new Job("Fix bug", 1),
                new Job("Impl task", 0));
        assertThat(jobs).isEqualTo(exp);
    }

    @Test
    void whenjobAscByPriority() {
        List<Job> jobs = new ArrayList<>(List.of(new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Finish the program", 2)));
        Collections.sort(jobs, new JobAscByPriority());
        List<Job> exp = List.of(new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Finish the program", 2));
        assertThat(jobs).isEqualTo(exp);
    }

    @Test
    void whenjobDesByPriority() {
        List<Job> jobs = new ArrayList<>(List.of(new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Finish the program", 2)));
        Collections.sort(jobs, new JobDescByPriority());
        List<Job> exp = List.of(new Job("Finish the program", 2),
                new Job("Fix bug", 1),
                new Job("Impl task", 0));
        assertThat(jobs).isEqualTo(exp);
    }

    @Test
    public void whenComparatorAscByNameAndPriority() {
        List<Job> jobs = new ArrayList<>(List.of(new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Finish the program", 2),
                new Job("Fix bug", 3),
                new Job("Impl task", 5),
                new Job("Impl task", 2)));
        jobs.sort(CombiComparators.COMBIASC);
        List<Job> exp = List.of(new Job("Finish the program", 2),
                new Job("Fix bug", 1),
                new Job("Fix bug", 3),
                new Job("Impl task", 0),
                new Job("Impl task", 2),
                new Job("Impl task", 5));
        System.out.println(jobs);
        assertThat(jobs).isEqualTo(exp);
    }

    @Test
    public void whenComparatorDesByNameAndPriority() {
        List<Job> jobs = new ArrayList<>(List.of(new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Finish the program", 2),
                new Job("Fix bug", 3),
                new Job("Impl task", 5),
                new Job("Impl task", 2)));
        jobs.sort(CombiComparators.COMBIDES);
        List<Job> exp = List.of(
                new Job("Impl task", 5),
                new Job("Impl task", 2),
                new Job("Impl task", 0),
                new Job("Fix bug", 3),
                new Job("Fix bug", 1),
                new Job("Finish the program", 2)
        );
        System.out.println(jobs);
        assertThat(jobs).isEqualTo(exp);
    }
}