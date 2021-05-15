package ru.job4j.oop;

public class Dentist extends Doctor {
    public Dentist(String name, String surname, String education,
                   String birthday, int specialization) {
        super(name, surname, education, birthday, specialization);
    }

    public boolean removeTheTooth() {
        return false;
    }
}
