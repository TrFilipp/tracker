package ru.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {

    private List<Item> itemList = new ArrayList<>();
    private final Item[] items = new Item[100];

    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        itemList.add(item);
        return item;
    }

    public List<Item> findAll() {
        //return Arrays.copyOf(items, size);
        return itemList;
    }

    public List<Item> findByName(String key) { //изменил
        List<Item> rsl = new ArrayList<>(); //Item[size];
        int sizeOfRsl = 0;
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            if (key.equals(item.getName())) {
                rsl.add(sizeOfRsl++, item);
            }
        }
        //rsl = Arrays.copyOf(rsl, sizeOfRsl);
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            itemList.set(index, item);
        }
        return index != -1;
    }

   private int indexOf(int id) { //изменил
       int rsl = -1;
       for (int index = 0; index < itemList.size(); index++) {
           Item item = itemList.get(index);
           if (item.getId() == id) {
               rsl = index;
               break;
           }
       }
       return rsl;
    }

    public Item findById(int id) { //изменил
        int index = indexOf(id);
        return index != -1 ? itemList.get(index) : null;
    }

    public void delete(int id) { // изменил
        int index = indexOf(id);
        if (index != -1) {
            /*System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;*/
            itemList.remove(index);
        }
    }
}