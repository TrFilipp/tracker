package ru.tracker;

public class DeleteAction implements UserAction {
    private final Output output;

    public DeleteAction(Output output) {
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
