package ru.job4j.tracker;

import java.util.Comparator;

public class SortDecrementByIdItem implements Comparator<Item> {
    @Override
    public int compare(Item first, Item second) {
        return second.compareTo(first);
    }
}
