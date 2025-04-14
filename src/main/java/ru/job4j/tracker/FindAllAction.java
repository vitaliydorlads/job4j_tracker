package ru.job4j.tracker;

public class FindAllAction implements UserAction {
    private final Output output;

    public FindAllAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать все заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = getItems(tracker);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.printl
        return true;
    }

    private static Item[] getItems(Tracker tracker) {
        System.out.println("=== Вывод всех заявок ===");
        return tracker.findAll();
    }
}
