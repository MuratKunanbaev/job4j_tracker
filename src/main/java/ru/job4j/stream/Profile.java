package ru.job4j.stream;

import java.util.Objects;

public class Profile {
    private String name;
    private String surname;
    private  int age;
    private Address address;

    public Profile(String name, String surname, int age, Address address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return age == profile.age && name.equals(profile.name) && surname.equals(profile.surname) && address.equals(profile.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
