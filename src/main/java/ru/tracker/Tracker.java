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
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            rsl[sizeOfRsl++] = item;
        }
        rsl = Arrays.copyOf(rsl, sizeOfRsl);
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int sizeOfRsl = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (key.equals(item.getName())) {
                rsl[sizeOfRsl++] = item;
            }
        }
        rsl = Arrays.copyOf(rsl, sizeOfRsl);
        return rsl;
    }

    /*public boolean replace(int id, Item item) {

    }*/

   /* private int indexOf(int id) {
        int rsl = -1;
        Item item = 
        if ()
        return rsl;
    }*/

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