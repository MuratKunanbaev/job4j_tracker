package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book mathematics  = new Book("Mathematics", 365);
        Book literature = new Book("Literature", 529);
        Book english = new Book("English", 235);
        Book cleanCode = new Book("Clean Code", 12);
        Book[] books = new Book[4];
        books[0] = mathematics;
        books[1] = literature;
        books[2] = english;
        books[3] = cleanCode;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getCount());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getCount());
        }
        System.out.println("Show only book.name Clean code");
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if (bk.getName() == "Clean Code") {
                System.out.println(bk.getName() + " - " + bk.getCount());
            }
        }
    }
}
