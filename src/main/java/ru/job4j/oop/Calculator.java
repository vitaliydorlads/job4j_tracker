package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int i) {
        return i - x;
    }

    public int divide(int s) {
        return s / x;
    }

    public int sumAllOperation(int a, int b, int c) {
        return sum(a) + minus(b) + divide(c);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        System.out.println("sumAllOperation: " + calculator.sumAllOperation(1, 2, 3));
        Calculator calculator1 = new Calculator();
        System.out.println("divide: " + calculator1.divide(10));
        System.out.println("sum: " + sum(2));
        System.out.println("minus: " + minus(10));
    }
}
