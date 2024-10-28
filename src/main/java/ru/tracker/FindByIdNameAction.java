package ru.tracker;

public class FindByIdNameAction implements UserAction {
    @Override
    public String name() {
        return "Нахождение заявки по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Вывод заявок по имени ===");
        String name = input.askStr("Введите имя: ");
        Item[] item = tracker.findByName(name);
        if (item.length == 0) {
            System.out.println("Заявки с именем: " + name +
                    " не найдены.");
        } else {
            for (Item items: item) {
                System.out.println(items);
            }
        }
        return true;
    }
}
