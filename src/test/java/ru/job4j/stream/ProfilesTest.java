package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void when2AddressInList() {
        List<Profile> profiles = List.of(
                new Profile("Ivan", "Ivanov", 25,
                        new Address("Moscow", "Lenina", 34, 2)),
                new Profile("Fedor", "Smirnov", 65,
                        new Address("St.Petersburg", "Pushkina", 6, 9))
        );
        Profiles prof = new Profiles();
        List<Address> rsl = prof.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moscow", "Lenina", 34, 2));
        expected.add(new Address("St.Petersburg", "Pushkina", 6, 9));
        assertThat(rsl, is(expected));
    }

    @Test
    public void when4AddressInList() {
        List<Profile> profiles = List.of(
                new Profile("Ivan", "Ivanov", 25,
                        new Address("Moscow", "Lenina", 34, 2)),
                new Profile("Fedor", "Smirnov", 65,
                        new Address("St.Petersburg", "Pushkina", 6, 9)),
                new Profile("Petr", "Sidorov", 32,
                        new Address("Samara", "Gagarina", 16, 3)),
                new Profile("Stanislav", "Gubanov", 41,
                        new Address("Volgograd", "Pugacheva", 47, 1))
        );
        Profiles prof = new Profiles();
        List<Address> rsl = prof.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moscow", "Lenina", 34, 2));
        expected.add(new Address("St.Petersburg", "Pushkina", 6, 9));
        expected.add(new Address("Samara", "Gagarina", 16, 3));
        expected.add(new Address("Volgograd", "Pugacheva", 47, 1));
        assertThat(rsl, is(expected));
    }

    @Test
    public void when2IdenticalProfiles() {
        List<Profile> profiles = List.of(
                new Profile("Fedor", "Smirnov", 65,
                        new Address("St.Petersburg", "Pushkina", 6, 9)),
                new Profile("Ivan", "Ivanov", 25,
                        new Address("Moscow", "Lenina", 34, 2)),
                new Profile("Petr", "Sidorov", 32,
                        new Address("Samara", "Gagarina", 16, 3)),
                new Profile("Ivan", "Ivanov", 25,
                        new Address("Moscow", "Lenina", 34, 2))
        );
        Profiles prof = new Profiles();
        List<Address> rsl = prof.collect(profiles);
        rsl = prof.sorted(rsl, prof.comparatorCity);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moscow", "Lenina", 34, 2));
        expected.add(new Address("Samara", "Gagarina", 16, 3));
        expected.add(new Address("St.Petersburg", "Pushkina", 6, 9));
        assertThat(rsl, is(expected));
    }
}