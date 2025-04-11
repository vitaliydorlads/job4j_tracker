package ru.job4j.tracker;

public class FindAllAction implements UserAction {
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
            System.out.println("Хранилище еще не содержит заявок");
        }
        return true;
    }

    private static Item[] getItems(Tracker tracker) {
        System.out.println("=== Вывод всех заявок ===");
        return tracker.findAll();
    }
}
