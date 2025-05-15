package ru.job4j.input;

import org.junit.jupiter.api.Test;
import ru.job4j.output.Output;
import ru.job4j.output.StubOutput;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidateInputTest {
    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                List.of("one", "1"));
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenCorrectInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                List.of("1"));
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenMultiCorrectInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                List.of("1", "2", "3"));
        ValidateInput input = new ValidateInput(output, in);
        int firstSelected = input.askInt("Enter menu:");
        assertThat(firstSelected).isEqualTo(1);
        int secondSelected = input.askInt("Enter menu:");
        assertThat(secondSelected).isEqualTo(2);
        int thirdSelected = input.askInt("Enter menu:");
        assertThat(thirdSelected).isEqualTo(3);
    }

    @Test
    void whenMinusValidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                List.of("-1"));
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }
}