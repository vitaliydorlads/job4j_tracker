package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {

    @Test
    public void whenArgumentException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Factorial.calc(-1);
                });
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    public void whenException() {
        int input = 5;
        int exp = 120;
        int res = Factorial.calc(input);
        assertThat(res).isEqualTo(exp);
    }
}
