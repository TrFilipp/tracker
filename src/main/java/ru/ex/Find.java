package ru.ex;

public class Find {
    public static String get(String[] data, int index) {
        if (index < 0 || index > data.length - 1) {
            throw new IllegalArgumentException("Index out of bound");
        }
        return data[index];
    }
}
