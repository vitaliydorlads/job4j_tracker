package ru.job4j.ooa;

public final class Airbus extends Aircraft {
    private static final int COUNT_ENGINE = 2;

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
        String input = String.valueOf(("A380").equals(getName()) ? 4 : COUNT_ENGINE);
        System.out.println("Количество двигателей равно: " + input);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name ='" + name + '\''
                + '}';
    }
}
