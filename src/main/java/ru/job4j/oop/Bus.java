package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " передвигается по дорогам.");
    }

    @Override
    public boolean canFly() {
        return false;
    }
}
