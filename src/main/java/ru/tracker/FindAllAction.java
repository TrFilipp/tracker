package ru.tracker;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "Вывод заявок";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("==== Вывод всех заявок ===");
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            System.out.println("Хранилище еще не содержит заявок");
        } else {
            for (Item item: items) {
                System.out.println(item);
            }
        }
        return true;
    }
}
