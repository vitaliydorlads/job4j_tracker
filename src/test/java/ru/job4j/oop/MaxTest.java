package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxTest {

    @Test
    public void testMaxWithTwoNumbers() {
        int result = Max.max(1, 2);
        assertEquals(2, result);
    }

    @Test
    public void testMaxWithThreeNumbers() {
        int result = Max.max(1, 2, 3);
        assertEquals(3, result);
    }

    @Test
    public void testMaxWithFourNumbers() {
        int result = Max.max(2, 2, 2, 1);
        assertEquals(2, result);
    }
}