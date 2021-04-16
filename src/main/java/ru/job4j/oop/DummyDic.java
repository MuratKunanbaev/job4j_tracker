package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String word = "Неизвестное слово " + eng;
        return word;
    }
    public static void main(String[] args) {
        DummyDic engDic = new DummyDic();
        String engWord = "Hello";
        String rusWord = engDic.engToRus(engWord);
        System.out.println(rusWord);
    }
}
