package ru.job4j.oop;

public class Error {
    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Активная: " + active + "," + " ошибка номер: " + status + ","
                + " Причина: " + message);
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error2 = new Error(true, 2, "Сбой активации");
        Error error3 = new Error(true, 3, "Не хватает памяти");
        error1.printInfo();
        error2.printInfo();
        error3.printInfo();
    }
}
