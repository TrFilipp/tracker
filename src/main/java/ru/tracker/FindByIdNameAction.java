package ru.tracker;

public class FindByIdNameAction implements UserAction {
    private final Output output;

    public FindByIdNameAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Нахождение заявки по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Вывод заявок по имени ===");
        String name = input.askStr("Введите имя: ");
        Item[] item = tracker.findByName(name);
        if (item.length == 0) {
            output.println("Заявки с именем: " + name +
                    " не найдены.");
        } else {
            for (Item items: item) {
               output.println(items);
            }
        }
        return true;
    }
}
