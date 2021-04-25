package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while(run) {
            this.showMenu();
            System.out.println("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] items = tracker.findAll();
                for (Item prl : items) {
                    System.out.println(prl);
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.println("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Replacement completed successfully!");
                } else {
                    System.out.println("Error!!! Replacement failed.");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.println("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                boolean rsl = tracker.delete(id);
                if (rsl) {
                    System.out.println("Object deletion completed!");
                } else {
                    System.out.println("Error!!! Deletion failed.");
                }
            } else if (select == 4) {
                System.out.println("=== Find Item by id ====");
                System.out.println("Enter id: ");
                int id = Integer.valueOf(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Error!!! Application with this id was not found.");
                }
            }else if (select ==5) {
                System.out.println("=== Find items by name ====");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item prl : items) {
                        System.out.println(prl);
                    }
                } else {
                    System.out.println("Error!!! Applications with this name not found.");
                }
            }else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit Item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit program");
    }
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       Tracker tracker = new Tracker();
       new StartUI().init(scanner, tracker);
    }
}
