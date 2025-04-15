package ru.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        if (left.length() != right.length()) {
            rsl = Integer.compare(left.length(), right.length());
        }
        for (int i = 0; i < Math.min(left.length(), right.length()) - 1; i++) {

            if (left.charAt(i) != right.charAt(i)) {
                rsl = Character.compare(left.charAt(i), right.charAt(i));
                break;
            }
        }
        return rsl;
    }
}
