package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(p -> p.getSubjects()
                                    .stream())
                                    .mapToInt(Subject::getScore)
                                    .average()
                                    .orElse(0D);

    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(p -> new Tuple(p.getName(), p.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .average()
                        .orElse(0D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(p -> p.getSubjects()
                .stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new,
                                    Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(t -> new Tuple(t.getKey(), t.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(p -> new Tuple(p.getName(), p.getSubjects().stream()
                            .mapToInt(Subject::getScore)
                            .sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(new Tuple("Empty", 0D));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
       return stream
             .flatMap(p -> p.getSubjects()
                .stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(t -> new Tuple(t.getKey(), t.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(new Tuple("Empty", 0D));
    }
}
