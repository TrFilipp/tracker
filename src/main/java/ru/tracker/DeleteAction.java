package ru.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Удаление заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Удаление заявки ===");
        int id = input.askInt("Введите id: ");
        tracker.delete(id);
        System.out.println(tracker.findById(id) != null ? "Ошибка удаления заявки"
                : "Заявка удалена успешно");
        return true;
    }
}
