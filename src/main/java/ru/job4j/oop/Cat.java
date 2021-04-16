package ru.job4j.oop;

public class Cat {
    private String name;
    private String food;
    public void giveNick(String nik) {
        this.name = nik;
    }
    public void eat(String meat) {
        this.food = meat;
    }
    public void show() {
        System.out.println(this.name);
        System.out.println(this.food);
    }
    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.giveNick("gav");
        gav.eat("kotleta");
        gav.show();
        Cat black = new Cat();
        black.giveNick("black");
        black.eat("fish");
        black.show();
    }
}
