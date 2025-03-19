package ru.job4j.oop;

public class Calculator {
    static private int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int i) {
        return i - x;
    }

    public int divide(int z) {
        return z / x;
    }

    public int sumAllOperation(int j) {
        return sum(j) + multiply(j) + minus(j) + divide(j);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int result1 = calculator.multiply(5);
        System.out.println(result1);
        int minus = Calculator.minus(10);
        System.out.println(minus);
        Calculator calculator1 = new Calculator();
        int res = calculator1.divide(20);
        System.out.println(res);
        Calculator calculator2 = new Calculator();
        int sum = calculator2.sumAllOperation(1);
        System.out.println(sum);
    }
}
