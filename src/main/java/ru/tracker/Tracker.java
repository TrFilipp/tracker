package ru.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {

    private List<Item> items = new ArrayList<>();

    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        int sizeOfRsl = 0;
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            if (key.equals(item.getName())) {
                rsl.add(sizeOfRsl++, item);
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items.set(index, item);
        }
        return index != -1;
    }

   private int indexOf(int id) {
       int rsl = -1;
       for (int index = 0; index < items.size(); index++) {
           Item item = items.get(index);
           if (item.getId() == id) {
               rsl = index;
               break;
           }
       }
       return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
        }
    }
}