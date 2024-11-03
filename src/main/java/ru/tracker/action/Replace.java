package ru.tracker.action;

import ru.tracker.input.Input;
import ru.tracker.Item;
import ru.tracker.output.Output;
import ru.tracker.Tracker;

public class Replace implements UserAction {
    private final Output output;

    public Replace(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Изменить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Редактирование заявки ===");
        int id = input.askInt("Введите id: ");
        String name = input.askStr("Введите имя: ");
        Item updateItem = new Item(name);
        tracker.replace(id, updateItem);
        if (tracker.replace(id, updateItem)) {
           output.println("Заявка изменена успешно.");
        } else {
           output.println("Ошибка замены заявки.");
        }
        return true;
    }
}
