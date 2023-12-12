package ru.job4j.oop;

public class Jukebox {
    public static void main(String[] args) {
        Jukebox position = new Jukebox();
        position.music(1);
        position.music(2);
        position.music(5);
    }

    public void music(int position) {
        switch (position) {
            case 1 -> System.out.println("Пусть бегут неуклюже");
            case 2 -> System.out.println("Спокойной ночи");
            default -> System.out.println("Песня не найдена");
        }
    }
}
