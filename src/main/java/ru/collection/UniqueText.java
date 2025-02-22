package ru.collection;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>(Arrays.asList(origin));
        for (String textCheck: text) {
            if (!check.contains(textCheck)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
