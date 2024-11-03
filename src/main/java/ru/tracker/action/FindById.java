package ru.tracker.action;

import ru.tracker.input.Input;
import ru.tracker.Item;
import ru.tracker.output.Output;
import ru.tracker.Tracker;

public class FindById implements UserAction {
    private final Output output;

    public FindById(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Нахождение заявки по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Вывод заявки по id ===");
        int id = input.askInt("Введите id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            output.println(item);
        } else {
           output.println("Заявка с введённым id: " + id + "не найдена.");
        }
        return true;
    }
}
