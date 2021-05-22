package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(
                1, 3, -5, 10, -1, 9
        );
        List<Integer> positiveNumber = numbers.stream().filter(
                number -> number > 0
        ).collect(Collectors.toList());

        positiveNumber.forEach(System.out::println);
    }
}
