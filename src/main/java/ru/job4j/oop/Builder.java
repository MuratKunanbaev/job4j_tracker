package ru.job4j.oop;

public class Builder extends Engineer {
    private String faculty;
    private int experience;

    public Builder(String name, String surname, String education, String birthday,
                   String fieldOfActivity, String faculty, int experience) {
        super(name, surname, education, birthday, fieldOfActivity);
        this.faculty = faculty;
        this.experience = experience;
    }

    public void estimate() {
    }
}
