package ru.job4j.pojo;
import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Ivanov Ivan Ivanovich");
        student.setGroupNumber("192");
        LocalDate date = LocalDate.of(2009, 9, 1);
        student.setReceiptDate(date);

        System.out.println(student.getFio() + " studying in a group number "
                + student.getGroupNumber() + " entered the University "
                + student.getReceiptDate());
    }
}
