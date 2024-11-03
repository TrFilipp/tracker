package ru.tracker.input;

public class Mock implements Input {
    public String[] answer;
    private int position = 0;

    public Mock(String[] answer) {
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
