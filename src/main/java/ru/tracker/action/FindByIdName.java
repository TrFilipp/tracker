package ru.tracker.action;

import ru.tracker.input.Input;
import ru.tracker.Item;
import ru.tracker.output.Output;
import ru.tracker.Tracker;

import java.util.List;

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
        List<Item> item = tracker.findByName(name);
        if (item.isEmpty()) {
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
