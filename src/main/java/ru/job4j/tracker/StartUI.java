package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item itemFirst = new Item("Заявка1");
        tracker.add(itemFirst);
        Item itemId = tracker.findById(itemFirst.getId());
        System.out.println(itemId.getId() + " - " + itemId.getName());
    }

}
