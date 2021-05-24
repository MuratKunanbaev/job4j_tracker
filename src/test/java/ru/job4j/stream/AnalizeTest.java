package ru.job4j.stream;


import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizeTest  {
    @Test
    public void whenZeroAdded() {
        List<Analize.User> previous = List.of(
                new Analize.User(1, "Ivan"),
                new Analize.User(2, "Nikolai"),
                new Analize.User(3, "Sergei")
        );
        List<Analize.User> current = List.of(
                new Analize.User(1, "Maxim"),
                new Analize.User(2, "Ivan"),
                new Analize.User(3, "Olya")
        );
        Analize analize = new Analize();
        Analize.Info rsl = analize.diff(previous, current);
        assertThat(rsl.added, is( 0));
    }

    @Test
    public void whenZeroDeleted() {
        List<Analize.User> previous = List.of(
                new Analize.User(1, "Ivan"),
                new Analize.User(2, "Nikolai"),
                new Analize.User(3, "Sergei")
        );
        List<Analize.User> current = List.of(
                new Analize.User(1, "Maxim"),
                new Analize.User(2, "Ivan"),
                new Analize.User(3, "Olya")
        );
        Analize analize = new Analize();
        Analize.Info rsl = analize.diff(previous, current);
        assertThat(rsl.deleted, is( 0));
    }

    @Test
    public void whenZeroChanged() {
        List<Analize.User> previous = List.of(
                new Analize.User(1, "Ivan"),
                new Analize.User(2, "Nikolai"),
                new Analize.User(3, "Sergei")
        );
        List<Analize.User> current = List.of(
                new Analize.User(4, "Maxim"),
                new Analize.User(5, "Ivan")

        );
        Analize analize = new Analize();
        Analize.Info rsl = analize.diff(previous, current);
        assertThat(rsl.changed, is( 0));
    }
}