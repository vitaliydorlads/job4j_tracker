package ru.job4j.oop;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {
    @Test
    public void whenThis000Another111distance3d1dot732() {
        Point point1 = new Point(0, 0, 0);
        Point point2 = new Point(1, 1, 1);
        assertEquals(1.732, point1.distance3d(point2), 0.001);
    }

    @Test
    public void whenThis111Another444distance3d5dot196() {
        Point point1 = new Point(1, 1, 1);
        Point point2 = new Point(4, 4, 4);
        assertEquals(5.196, point1.distance3d(point2), 0.001);
    }
}