package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(active);
        System.out.println(status);
        System.out.println(message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        System.out.println();
        Error error1 = new Error(true, 1, "Проверка не завершена");
        error1.printInfo();
        System.out.println();
        Error error2 = new Error(false, 0, "Проверка завершена");
        error2.printInfo();
    }
}
