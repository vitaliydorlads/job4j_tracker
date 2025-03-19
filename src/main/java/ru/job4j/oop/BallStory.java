package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Fox fox = new Fox();
        Wolf wolf = new Wolf();
        System.out.println("От зайца");
        hare.tryEat(ball);
        System.out.println("От лисы ");
        fox.tryEat(ball);
        System.out.println("От волка");
        wolf.tryEat(ball);
    }
}
