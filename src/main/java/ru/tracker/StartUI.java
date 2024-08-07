package ru.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item dateTimeNow = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeNow = dateTimeNow.getCreated().format(formatter);
        System.out.println("Текущее дата и время: " + currentDateTimeNow);
    }
}
