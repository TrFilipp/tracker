package ru.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Класс реализует переопределённый метод для сравнения строк, благодаря которому будет произведена сортировка по убывающему
 * @author trishin_f
 * @version 1.0
 */
public class DepartmentsDescComparator implements Comparator<String> {
    /**
     * Переопределённый метод для сравнения строк
     * @param left the first object to be compared.
     * @param right the second object to be compared.
     * @return Возвращает числовое значение в виде разницы двух строк
     */
    @Override
    public int compare(String left, String right) {
        ArrayList<String> tempLeft = new ArrayList<>(List.of(left.split("/")));
        ArrayList<String> tempRight = new ArrayList<>(List.of(right.split("/")));
        int rsl = tempRight.get(0).compareTo(tempLeft.get(0));
        if (tempRight.get(0).compareTo(tempLeft.get(0)) == 0)  {
            rsl = left.compareTo(right);
        }
        return rsl;
    }
}
