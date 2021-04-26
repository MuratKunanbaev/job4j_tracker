package ru.job4j.oop;

public class Plane implements Vehicle{
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по воздуху.");
    }

    @Override
    public boolean canFly() {
        return true;
    }
}
