package ru.job4j.сheckstyle;

public class Broken {
    String name;
    public  String surname;
    private int sizeOfEmpty = 10;
    public static String newValue = "";

    void echo() {
    }

    void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    public void method(int a, int b, int c) {
    }

    public void broken() {
    }
}