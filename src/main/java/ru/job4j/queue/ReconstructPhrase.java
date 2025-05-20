package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder buffer = new StringBuilder();
        int count = evenElements.size();
        for (int i = 0; i < count; i++) {
            char ch = evenElements.poll();
            if (i % 2 == 0) {
                buffer.append(ch);
            }
        }
        return buffer.toString();
    }

    private String getDescendingElements() {
        StringBuilder buffer = new StringBuilder();
        int count = descendingElements.size();
        for (int i = 0; i < count; i++) {
            char ch = descendingElements.pollLast();
            buffer.append(ch);
        }
        return buffer.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
