package ru.job4j.oop;

public class Engineer extends Profession {
    private String fieldOfActivity;

    public Engineer(String name, String surname, String education, String birthday, String fieldOfActivity) {
       super(name, surname,education, birthday);
       this.fieldOfActivity = fieldOfActivity;
    }
    public void calculate(){
    }
}
