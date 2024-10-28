package ru.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Нахождение заявки по id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Вывод заявки по id ===");
        int id = input.askInt("Введите id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с введённым id: " + id + "не найдена.");
        }
        return true;
    }
}
