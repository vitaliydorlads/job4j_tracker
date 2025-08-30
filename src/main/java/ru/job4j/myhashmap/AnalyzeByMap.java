package ru.job4j.myhashmap;

import java.util.*;
import java.util.Collections;
import java.util.List;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int sum = 0;
        int counter = 0;
        for (Pupil index : pupils) {
            List<Subject> res = index.subjects();
            for (Subject subject : res) {
                sum += subject.score();
                counter++;
            }
        }
        return (double) sum / counter;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> res = new ArrayList<>();
        for (Pupil index : pupils) {
            String name = index.name();
            double sum = 0;
            int counter = 0;
            List<Subject> subjects = index.subjects();
            for (Subject subject : subjects) {
                sum += subject.score();
                counter++;
            }
            double score = counter == 0 ? 0 : sum / counter;
            res.add(new Label(name, score));
        }
        return List.copyOf(res);
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> res = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil index : pupils) {
            List<Subject> subjects = index.subjects();
            for (Subject subject : subjects) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        int pupil = pupils.size();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            double average = (double) entry.getValue() / pupil;
            res.add(new Label(key, average));
        }
        return List.copyOf(res);
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> res = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil index : pupils) {
            String name = index.name();
            List<Subject> subjects = index.subjects();
            for (Subject subject : subjects) {
                int sum = subject.score();
                map.put(name, map.getOrDefault(name, 0) + sum);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int average = entry.getValue();
            res.add(new Label(key, average));
        }
        if (res.isEmpty()) {
            return null;
        }
        return Collections.max(res);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> res = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil index : pupils) {
            List<Subject> subjects = index.subjects();
            for (Subject subject : subjects) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int sum = entry.getValue();
            res.add(new Label(key, sum));
        }
        return Collections.max(res);
    }
}
