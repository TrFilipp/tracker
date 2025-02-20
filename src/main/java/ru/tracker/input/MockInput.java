package ru.tracker.input;

import java.util.List;

public class MockInput implements Input {
    public List<String> answer;
    private int position = 0;

    public MockInput(List<String> answer) {
        this.answer = answer;
    }

    @Override
    public String askStr(String question) {
        return answer.get(position++);
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
