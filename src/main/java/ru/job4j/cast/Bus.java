package ru.job4j.cast;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println("Автобус двигается по скоростным трассам");
    }

    @Override
    public void speed() {
        System.out.println("Набирает скрость до 100 км/ч");
    }
}
