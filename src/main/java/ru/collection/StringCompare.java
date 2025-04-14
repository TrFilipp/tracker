package ru.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        if (left.length() > right.length()) {
            right += "A";
        } else if (left.length() < right.length()) {
            left += "A";
        }
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) > right.charAt(i) || left.charAt(i) < right.charAt(i)) {
                rsl = Character.compare(left.charAt(i), right.charAt(i));
                break;
            }
        }
        return rsl;
    }
}
