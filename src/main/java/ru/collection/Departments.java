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
        for (String department : departments) {
            ArrayList<String> sections = new ArrayList<>(List.of(department.split("/")));
            for (int i = 1; i <= sections.size(); i++) {
                temp.add(String.join("/", sections.subList(0, i)));
            }
            temp.add(department);
        }
        return new ArrayList<>(temp);
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
        DepartmentsDescComparator descComparator = new DepartmentsDescComparator();
        departments.sort(descComparator);
    }
}
