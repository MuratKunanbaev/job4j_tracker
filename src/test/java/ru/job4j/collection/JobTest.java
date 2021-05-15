package ru.job4j.collection;


import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
       Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
       int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByIncNameAndIncPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("X task", 3),
                new Job("Fix bug", 2)
        );
        Collections.sort(jobs, new JobIncByName().thenComparing(new JobIncByPriority()));
        assertThat(jobs.get(0).getPriority(), is(1));
    }

    @Test
    public void whenComparatorByDescNameAndIncPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("X task", 5),
                new Job("Fix bug", 2),
                new Job("X task", 3)
        );
        Collections.sort(jobs, new JobDescByName().thenComparing(new JobIncByPriority()));
        assertThat(jobs.get(0).getPriority(), is(3));
    }
}