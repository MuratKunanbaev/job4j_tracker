package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String word : origin) {
            check.add(word);
        }
        for (String word : text) {
           if(!check.contains(word)){
               rsl = false;
           };
        }
        return rsl;
    }

    public static void main(String[] args) {
        String origin = "My cat eats a mouse";
        String text = "A mouse is eaten by a cat";
        boolean rsl = UniqueText.isEquals(origin, text);
    }
}
