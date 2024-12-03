package ru.tracker.input;

public class MockInput implements Input {
    public String[] answer;
    private int position = 0;

    public MockInput(String[] answer) {
        this.answer = answer;
    }

    @Override
    public String askStr(String question) {
        return answer[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
