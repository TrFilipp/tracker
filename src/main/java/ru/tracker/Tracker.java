package ru.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] rsl = new Item[size];
        int sizeOfRsl = 0;
        for (int i = 0; i < items.length; i++) {
            Item name = items[i];
            if (name != null) {
                rsl[sizeOfRsl] = name;
                sizeOfRsl++;
            }
        }
        rsl = Arrays.copyOf(rsl, sizeOfRsl);
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int sizeOfRsl = 0;
        for (int i = 0; i < size; i++) {
            Item name = items[i];
            if (key.equals(name.getName())) {
                rsl[sizeOfRsl] = name;
                sizeOfRsl++;
            }
        }
        rsl = Arrays.copyOf(rsl, sizeOfRsl);
        return rsl;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}