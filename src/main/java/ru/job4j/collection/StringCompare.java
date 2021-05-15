package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int size = left.length() <= right.length() ? left.length() : right.length();
        int rsl = 0;
        for (int index = 0; index < size; index++) {
            char l = left.charAt(index);
            char r = right.charAt(index);
           rsl = Character.compare(l,r);
           if (rsl != 0) {
               break;
           }
        }
        if (rsl == 0 && left.length() > size) {
            return  size - left.length();
        } else if (rsl == 0 && right.length() > size) {
            return size - right.length();
        } else {
            return rsl;
        }
    }
}
