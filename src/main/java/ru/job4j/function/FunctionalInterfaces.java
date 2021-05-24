package ru.job4j.function;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        List<String> list = List.of(
                "one", "two", "three", "four", "five", "six", "seven"
        );
        BiConsumer<Integer, String> biCon = (s, s1) -> map.put(s, s1);
        int index = 1;
        for (String s : list) {
            biCon.accept(index++, s);
        }

        BiPredicate<Integer, String> biPred = (i, s) ->
             i % 2 == 0 || s.length() == 4;

        for (Integer j : map.keySet()) {
            if (biPred.test(j, map.get(j))) {
                System.out.println("key: " + j + " value: " + map.get(j));
            }
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());

        Consumer<String> con = (s) -> System.out.println(s);
        Function<String, String> func = (s) -> s.toUpperCase();
        for (String s : sup.get()) {
            con.accept(func.apply(s));
        }

    }
}
