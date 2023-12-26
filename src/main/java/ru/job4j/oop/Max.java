package ru.job4j.oop;

public class Max {
    public static int max(int left, int right) {
        return left > right ? left : right;
    }

    public static int max(int left, int right, int directly) {
        return max(left, right) > directly ? max(left, right) : directly;
    }

    public static int max(int left, int right, int directly, int back) {
        return max(directly, back) > max(left, right) ? max(directly, back) : max(left, right);
    }

    public static void main(String[] args) {
        int a = max(1, 2);
        int b = max(1, 2, 3);
        int c = max(2, 2, 2, 1);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
