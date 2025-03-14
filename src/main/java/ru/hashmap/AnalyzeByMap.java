package ru.hashmap;

import java.util.List;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        for (Pupil pupil: pupils) {
            pupil.subjects();
        }
        return 0D;
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
