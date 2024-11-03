package ru.tracker;

import org.junit.jupiter.api.Test;
import ru.tracker.action.*;
import ru.tracker.input.Input;
import ru.tracker.output.Mock;
import ru.tracker.output.Output;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenCreateItem() {
        Output output = new Mock();
        Input input = new ru.tracker.input.Mock(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Create(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Output output = new Mock();
        Input input = new ru.tracker.input.Mock(
                new String[] {"0", "1", "Item name test", "1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("Item name"));
        UserAction[] actions = {
                new Replace(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name test");
    }

    @Test
    void whenDeleteItem() {
        Output output = new Mock();
        Input input = new ru.tracker.input.Mock(
                new String[] {"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        tracker.add(new Item("Item name"));
        UserAction[] actions = {
                new Delete(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(1)).isNull();
    }

    @Test
    void whenExit() {
        Output output = new Mock();
        Input input = new ru.tracker.input.Mock(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new Mock();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input input = new ru.tracker.input.Mock(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new Replace(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "=== Редактирование заявки ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

   @Test
    void whenFindAllItemTestOutputIsSuccessfully() {
        Output output = new Mock();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        Item three = tracker.add(new Item("test3"));
        Input input = new ru.tracker.input.Mock(
                new String[] {"0", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindAll(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Вывод заявок" + ln
                        + "1. Завершить программу" + ln
                        + "==== Вывод всех заявок ===" + ln
                        + one + ln
                        + two + ln
                        + three + ln
                        + "Меню:" + ln
                        + "0. Вывод заявок" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByNameItemTestOutputIsSuccessfully() {
        Output output = new Mock();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        Item three = tracker.add(new Item("test1"));
        Input input = new ru.tracker.input.Mock(
                new String[] {"0", String.valueOf(one.getName()), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByIdName(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Нахождение заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявок по имени ===" + ln
                        + one + ln
                        + three + ln
                        + "Меню:" + ln
                        + "0. Нахождение заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByIdItemTestOutputIsSuccessfully() {
        Output output = new Mock();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        Item three = tracker.add(new Item("test3"));
        Input input = new ru.tracker.input.Mock(
                new String[] {"0", String.valueOf(two.getId()), "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindById(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Нахождение заявки по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявки по id ===" + ln
                        + two + ln
                        + "Меню:" + ln
                        + "0. Нахождение заявки по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }
}