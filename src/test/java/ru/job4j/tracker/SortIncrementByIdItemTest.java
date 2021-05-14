package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortIncrementByIdItemTest  {
    @Test
    public void testCompare() {
        List<Item> items = Arrays.asList(
                new Item(5, "five"),
                new Item(1, "first"),
                new Item(6, "six"),
                new Item(2, "second")
        );
        Collections.sort(items, new SortIncrementByIdItem());
        assertThat(items.get(0).getId(), is(1));
    }
}