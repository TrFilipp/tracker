package ru.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Выбрать: ");
            if (select == 0) {
                System.out.println("==== Создание новой заявки ===");
                String name = input.askStr("Введите имя: ");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавлена заявка: " + item);
            } else if (select == 1) {
                System.out.println("==== Вывод всех заявок ===");
                Item[] items = tracker.findAll();
                if (items.length == 0) {
                    System.out.println("Хранилище еще не содержит заявок");
                } else {
                    for (Item item: items) {
                        System.out.println(item);
                    }
                }
            } else if (select == 2) {
                System.out.println("=== Изменение заявки ===");
                int id = input.askInt("Введите id: ");
                String name = input.askStr("Введите имя: ");
                Item updateItem = new Item(name);
                tracker.replace(id, updateItem);
                if (tracker.replace(id, updateItem)) {
                    System.out.println("Заявка изменена успешно.");
                } else {
                    System.out.println("Ошибка замены заявки.");
                }
            } else if (select == 3) {
                System.out.println("=== Удаление заявки ===");
                int id = input.askInt("Введите id: ");
                tracker.delete(id);
                System.out.println(tracker.findById(id) == null ? "Ошибка удаления заявки"
                        : "Заявка удалена успешно");
            } else if (select == 4) {
                System.out.println("=== Вывод заявки по id ===");
                int id = input.askInt("Введите id: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Заявка с введённым id: " + id + "не найдена.");
                }
            } else if (select == 5) {
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
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Добавить новую заявку", "Показать все заявки", "Изменить заявку",
                "Удалить заявку", "Показать заявку по id", "Показать заявки по имени", "Завершить программу"
        };
        System.out.println("Меню:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
