package ru.tracker.action;

import ru.tracker.input.Input;
import ru.tracker.output.Output;
import ru.tracker.Tracker;

public class Delete implements UserAction {
    private final Output output;

    public Delete(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Удаление заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Удаление заявки ===");
        int id = input.askInt("Введите id: ");
        tracker.delete(id);
        output.println(tracker.findById(id) != null ? "Ошибка удаления заявки"
                : "Заявка удалена успешно");
        return true;
    }
}
