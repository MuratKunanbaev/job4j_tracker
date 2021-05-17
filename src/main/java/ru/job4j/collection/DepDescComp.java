package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String first, String second) {
        String[] strFirst = first.split("/");
        String[] strSecond = second.split("/");
        int rsl  = strSecond[0].compareTo(strFirst[0]);
        if (rsl != 0) {
            return rsl;
        }
        return first.compareTo(second);
    }
}
