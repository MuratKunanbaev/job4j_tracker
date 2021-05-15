package ru.job4j.ex;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class FactTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenLess0() {
        Fact.calc(-1);
    }

    @Test
    public void when5Then120() {
        int rsl = Fact.calc(5);
       assertThat(rsl, is(120));
    }
}