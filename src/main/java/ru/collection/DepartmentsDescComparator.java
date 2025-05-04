package ru.collection;

import java.util.Comparator;

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
        int rsl = right.split("/")[0].compareTo(left.split("/")[0]);
        if (rsl == 0)  {
            rsl = left.compareTo(right);
        }
        return rsl;
    }
}
