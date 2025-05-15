package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.action.*;
import ru.job4j.input.Input;
import ru.job4j.input.MockInput;
import ru.job4j.output.Output;
import ru.job4j.output.StubOutput;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class StartUITest {
    @Test
    void whenInvalidExit() {
        Output output = new StubOutput();
        Input input = new MockInput(List.of("10", "0"));
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "Неверный ввод, вы можете выбрать: 0 .. 0" + ln
                        + "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }
}