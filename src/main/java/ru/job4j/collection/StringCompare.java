package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int index = 0; index < Math.min(left.length(), right.length()); index++) {
            char l = left.charAt(index);
            char r = right.charAt(index);
            if (l != r) {
                return Character.compare(l, r);
            }
        }
        return  Integer.compare(left.length(), right.length());
    }
}
