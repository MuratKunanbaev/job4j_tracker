package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
     return profiles.stream()
               .map(Profile::getAddress)
             .collect(Collectors.toList());
    }
    Comparator<Address> comparatorCity = new Comparator<Address>() {
        @Override
        public int compare(Address o1, Address o2) {
            return o1.getCity().compareTo(o2.getCity());
        }
    };

    public List<Address> sorted(List<Address> list, Comparator<Address> comp) {
        return list.stream()
                .sorted(comp)
                .distinct()
                .collect(Collectors.toList());
    }
}
