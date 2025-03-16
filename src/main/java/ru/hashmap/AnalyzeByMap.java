package ru.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        List<Integer> scores = new ArrayList<>();
        double sum = 0;
        double sumAll = 0;
        int subjectAll = 0;
        for (Pupil pupil : pupils) {
            subjectAll += pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                scores.add(subject.score());
            }
            for (int i = 0; i < scores.size(); i++) {
                sum += scores.get(i);
            }
            sumAll += sum;
            sum = 0;
            scores.clear();
        }
        sumAll /= subjectAll;
        return sumAll;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Integer> scores = new ArrayList<>();
        List<Label> label = new ArrayList<>();
        double sum = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scores.add(subject.score());
            }
            for (int i = 0; i < scores.size(); i++) {
                sum += scores.get(i);
            }
            sum /= scores.size();
            label.add(new Label(pupil.name(), sum));
            sum = 0;
            scores.clear();
        }
        return label;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        LinkedHashMap<String, Integer> scoreBySubject = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        int value;
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
        for (String name: scoreBySubject.keySet()) {
            value = scoreBySubject.get(name);
            value /= pupils.size();
            labels.add(new Label(name, value));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Integer> scores = new ArrayList<>();
        List<Label> label = new ArrayList<>();
        int sum = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scores.add(subject.score());
            }
            for (int i = 0; i < scores.size(); i++) {
                sum += scores.get(i);
            }
            label.add(new Label(pupil.name(), sum));
            sum = 0;
            scores.clear();
        }
        Collections.sort(label);
        return label.get(label.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        LinkedHashMap<String, Integer> scoreBySubject = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
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
        for (String name: scoreBySubject.keySet()) {
            labels.add(new Label(name, scoreBySubject.get(name)));
        }
        Collections.sort(labels);
        return labels.get(labels.size() - 1);
    }
}
