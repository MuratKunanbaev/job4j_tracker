package ru.job4j.collection;


import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class JobIncByPriorityTest {
    @Test
    public void whenComparatorByPriorityIncrement() {
        List<Job> jobs = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("X task", 3),
                new Job("Fix bug", 2)
        );
        Collections.sort(jobs, new JobIncByPriority());
        assertThat(jobs.get(0).getPriority(), is(0));
    }
}