package ru.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("hhru@tver.ru", "Nikolai Borisovich Borzoi");
        map.put("linkov_a@gmail.com", "Aleksandr Vasilievich Linkov");
        for (String key: map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
