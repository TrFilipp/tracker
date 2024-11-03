package ru.tracker.action;

import ru.tracker.input.Input;
import ru.tracker.Item;
import ru.tracker.output.Output;
import ru.tracker.Tracker;

public class FindByIdName implements UserAction {
    private final Output output;

    public FindByIdName(Output output) {
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
