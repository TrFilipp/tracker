package ru.hashmap;

import java.util.ArrayList;
import java.util.List;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        List<Integer> scores = new ArrayList<>();
        double sum = 0;
        double sumAll = 0;
        int subjectAll = 0;

        for (Pupil pupil : pupils) {
            pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                scores.add(subject.score());
                subjectAll++;
            }
            for (int i = 0; i < scores.size(); i++) {
                sum += scores.get(i);
            }
            sum /= subjectAll;
            sumAll += sum;
            sum = 0;
        }
        return sumAll;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        return List.of();
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        return List.of();
    }

    public static Label bestStudent(List<Pupil> pupils) {
        return null;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        return null;
    }
}
