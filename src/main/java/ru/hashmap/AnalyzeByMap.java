package ru.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sumAll = 0;
        int subjectAll = 0;
        for (Pupil pupil : pupils) {
            double sum = 0;
            subjectAll += pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            sumAll += sum;
        }
        sumAll /= subjectAll;
        return sumAll;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> label = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            sum /= pupil.subjects().size();
            label.add(new Label(pupil.name(), sum));
        }
        return label;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        LinkedHashMap<String, Integer> scoreBySubject = subjectAdd(pupils);
        List<Label> labels = new ArrayList<>();
        for (String name: scoreBySubject.keySet()) {
            int value = scoreBySubject.get(name);
            value /= pupils.size();
            labels.add(new Label(name, value));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> label = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            label.add(new Label(pupil.name(), sum));
        }
        Collections.sort(label);
        return label.get(label.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        LinkedHashMap<String, Integer> scoreBySubject = subjectAdd(pupils);
        List<Label> labels = new ArrayList<>();
        for (String name: scoreBySubject.keySet()) {
            labels.add(new Label(name, scoreBySubject.get(name)));
        }
        Collections.sort(labels);
        return labels.get(labels.size() - 1);
    }

    private static LinkedHashMap<String, Integer> subjectAdd(List<Pupil> pupils) {
        LinkedHashMap<String, Integer> scoreBySubject = new LinkedHashMap<>();
        for (Pupil pupil: pupils) {
            for (Subject subject: pupil.subjects()) {
                if (scoreBySubject.containsKey(subject.name())) {
                    int score = scoreBySubject.get(subject.name());
                    score += subject.score();
                    scoreBySubject.put(subject.name(), score);
                } else {
                    scoreBySubject.put(subject.name(), subject.score());
                }
            }
        }
        return scoreBySubject;
    }
}
