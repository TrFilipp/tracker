package ru.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class FullSearch {

    public Set<String> extractNumber(List<Task> tasks) {
        Set<String> rsl = new HashSet<>();
        for (Task task: tasks) {
            rsl.add(task.getNumber());
        }
        return rsl;
    }
}
