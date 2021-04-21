package ru.job4j.oop;

public class Surgeon extends Doctor {
    private int numberPerformedOperation;

    public Surgeon(String name, String surname, String education, String birthday, int specialization, int numberPerformedOperation){
        super(name,surname,education, birthday,specialization);
        this.numberPerformedOperation = numberPerformedOperation;
    }
    public boolean operation(){
        return false;
    }
}
