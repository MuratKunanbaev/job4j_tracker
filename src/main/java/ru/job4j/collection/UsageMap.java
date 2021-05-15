package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String>  map = new HashMap<>();
        map.put("kunanbaev.murat", "Kunanbaev Murat Kazhigalievich");
        map.put("lkl", "shgdhgs");
        for (String key : map.keySet()) {
            String value  = map.get(key);
            if (key.equals("wdqwdq")) {
                System.out.println(key + " = " + value);
            } else {
                System.out.println("такой нет");
            }
        }
    }
}
