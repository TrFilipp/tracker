package ru.collection;

import java.util.*;
import java.util.ArrayList;

public class Departments {

    /**
     * Метод заполняет коллекцию недостающими элементами исходя из полученных данных
     * @param departments список департаментов
     * @return возвращает список всех подразделений
     */
    public static List<String> fillGaps(List<String> departments) {
        Set<String> temp = new LinkedHashSet<>();
        StringJoiner sj = new StringJoiner("/");
        List<String> rsl = new ArrayList<>();
        for (String department : departments) {
            List<String> sections = new ArrayList<>(List.of(department.split("/")));
            for (String s: sections) {
                sj.add(s);
                temp.add(sj.toString());
            }
            sj = new StringJoiner("/");
            rsl.addAll(temp);
        }
        return rsl;
    }

    /**
     * Метод сортирует список по возрастанию
     * @param departments список департаментов
     */
    public static void sortAsc(List<String> departments) {
        departments.sort(Comparator.naturalOrder());
    }

    /**
     * Метод сортирует список по убыванию, используя компаратор DepartmentsDescComparator
     * @param departments список департаментов
     */
    public static void sortDesc(List<String> departments) {
        departments.sort(new DepartmentsDescComparator());
    }

    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("K1/SK1");
        test.add("K2/SK1");
        List<String> rsl = fillGaps(test);
        System.out.println(rsl);
    }
}
