package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public int multiply(int a) {
        return x * a;
    }

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int i) {
        return i - x;
    }

    public int divide(int s) {
        return s / x;
    }

    public int sumAllOperation(int sumAll) {
        return sum(sumAll) + minus(sumAll) + divide(sumAll) + multiply(sumAll);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("sumAllOperation: " + calculator.sumAllOperation(1));
        System.out.println("divide: " + calculator.divide(10));
        System.out.println("sum: " + sum(2));
        System.out.println("minus: " + minus(10));
        System.out.println("multiply: " + calculator.multiply(7));
    }
}
