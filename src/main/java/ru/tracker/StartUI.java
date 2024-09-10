package ru.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item(10, "test");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String formatDateItem = item.getCreated().format(formatter);
        System.out.println("Дата и время создания заявки: " + formatDateItem);
        System.out.println(item);
    }
}
