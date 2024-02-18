package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Каруфин Виталий Александрович");
        student.setGroup("ЗПЭ - 462");
        student.setDateOfReceipt("13.02.2024");
        System.out.println(student.getFullName() + System.lineSeparator() + "Группа: " + student.getGroup() + System.lineSeparator() + "Дата поступления: " + student.getDateOfReceipt());
    }
}
