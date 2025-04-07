package ru.job4j.cast;

public class Aircraft implements Vehicle {

    @Override
    public void move() {
        System.out.println("Самолет летает по воздуху");
    }

    @Override
    public void speed() {
        System.out.println("Набирает скорость до 1000 км/ч");
    }
}
