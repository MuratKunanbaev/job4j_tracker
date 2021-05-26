package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class JobDescByNameTest  {
    @Test
    public void whenComparatorByNameIncrement() {
        List<Job> jobs = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("X task", 3)
        );
        Collections.sort(jobs, new JobDescByName());
        assertThat(jobs.get(0).getName(), is("X task"));
    }
}