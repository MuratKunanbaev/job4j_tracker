package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println(
                    "Пусть бегут неуклюже," + System.lineSeparator()
                    + "Пешеходы по лужам," + System.lineSeparator()
                    + "А вода по асфальту рекой." + System.lineSeparator()
                    + "И неясно прохожим," + System.lineSeparator()
                    + "В этот день непогожий," + System.lineSeparator()
                    + "Почему я весёлый такой.");
        } else if (position == 2) {
            System.out.println(
                    "Спят усталые игрушки, книжки спят." + System.lineSeparator()
                    + "Одеяла и подушки ждут ребят." + System.lineSeparator()
                    + "Даже сказка спать ложится," + System.lineSeparator()
                    + "Что бы ночью нам присниться." + System.lineSeparator()
                    + "Ты ей пожелай:" + System.lineSeparator()
                    + "Баю-бай.");
        } else {
            System.out.println("Песня не найдена.");
        }
    }

    public static void main(String[] args) {
        Jukebox song = new Jukebox();
        int position = 1;
        song.music(position);
    }
}
