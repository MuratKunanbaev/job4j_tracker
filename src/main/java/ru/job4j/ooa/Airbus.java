package ru.job4j.ooa;

public final class Airbus extends Aircraft{
    private static int COUNT_ENGINE;

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
        if (name.equals("A380")) {
            COUNT_ENGINE = 4;
        } else {
            COUNT_ENGINE = 2;
        }
        System.out.println("Количество двигателей равно: " + COUNT_ENGINE);

    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                 + '}';
    }
}
