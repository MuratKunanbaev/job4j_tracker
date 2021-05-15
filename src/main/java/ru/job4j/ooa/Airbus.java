package ru.job4j.ooa;

public final class Airbus extends Aircraft {
    private static int countEngine = 2;

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine(String name) {
        int engines = "A380".equals(name) ? 4 : countEngine;
        System.out.println("Количество двигателей равно: " + engines);

    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                 + '}';
    }
}
