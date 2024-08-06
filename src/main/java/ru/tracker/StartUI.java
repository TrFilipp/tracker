package ru.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        LocalDateTime date = Item.created();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = date.format(formatter);
        System.out.println("Текущее дата и время: " + currentDateTimeFormat);
    }
}
