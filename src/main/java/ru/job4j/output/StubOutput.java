package ru.job4j.output;

public class StubOutput implements Output {
    private final StringBuffer buffer = new StringBuffer();

    @Override
    public void println(Object object) {
        if (object != null) {
            buffer.append(object.toString());
        } else {
            buffer.append("null");
        }
        buffer.append(System.lineSeparator());
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}
