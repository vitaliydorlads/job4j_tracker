package ru.job4j.input;

import java.util.List;

public class MockInput implements Input {
    private List<String> answers;
    private int position = 0;

    public MockInput(List<String> answers) {
            this.answers = answers;
        }

        @Override
        public String askStr(String question) {
            return answers.get(position++);
        }

        @Override
        public int askInt(String question) {
            return Integer.parseInt(askStr(question));
        }
}
