package ru.collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String originCheck: origin) {
            check.add(originCheck);
        }
        for (String textCheck: text) {
            if (!check.contains(textCheck)) {
                rsl = false;
            }
        }
        return rsl;
    }
}
