package ru.job4j.oop;

public class Programmer extends Engineer {
    private String programmingLanguage;
    private String programmerLevel;

    public Programmer(String name, String surname, String education, String birthday, String fieldOfActivity, String programmingLanguage, String programmerLevel) {
        super(name, surname, education, birthday, fieldOfActivity);
        this.programmingLanguage = programmingLanguage;
        this.programmerLevel = programmerLevel;
    }

    public void createProgram(){
    }
}
