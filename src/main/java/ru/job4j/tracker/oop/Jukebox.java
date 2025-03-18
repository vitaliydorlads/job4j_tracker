package ru.job4j.tracker.oop;

public class Jukebox {
    public void music(int position) {
        switch (position) {
            case 1 -> System.out.println("Пусть бегут неуклюже");
            case 2 -> System.out.println("Спокойной ночи");
            default -> System.out.println("Песня не найдена");

        }
    }

    public static void main(String[] args) {
        Jukebox menu = new Jukebox();
        menu.music(1);
        menu.music(2);
        menu.music(3);
    }
}
