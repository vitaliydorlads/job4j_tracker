package ru.job4j.cast;

public class UseVehicle {
    public static void main(String[] args) {
        Vehicle aircraft = new Aircraft();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[] vehicles = new Vehicle[]{aircraft, train, bus};
        for (Vehicle object : vehicles) {
           object.move();
           object.speed();
        }
    }
}
