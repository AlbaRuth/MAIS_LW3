package org.example.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PointTest{

    @Test
    void testPointCreation() {
        Point point = new Point(1.0, 2.0);
        assertEquals(1.0, point.getX(), 0.0001);
        assertEquals(2.0, point.getY(), 0.0001);
    }

    @Test
    void testEqualsSamePoint() {
        Point point1 = new Point(1.0, 2.0);
        Point point2 = new Point(1.0, 2.0);
        assertEquals(point1, point2);
    }

    @Test
    void testEqualsDifferentPoints() {
        Point point1 = new Point(1.0, 2.0);
        Point point2 = new Point(2.0, 3.0);
        assertNotEquals(point1, point2);
    }

    @Test
    void testEqualsWithNull() {
        Point point = new Point(1.0, 2.0);
        assertNotEquals(point, null);
    }

    @Test
    void testEqualsWithDifferentClass() {
        Point point = new Point(1.0, 2.0);
        String notAPoint = "Not a Point";
        assertNotEquals(point, notAPoint);
    }

    @Test
    void testHashCodeSamePoint() {
        Point point1 = new Point(1.0, 2.0);
        Point point2 = new Point(1.0, 2.0);
        assertEquals(point1.hashCode(), point2.hashCode());
    }

    @Test
    void testHashCodeDifferentPoints() {
        Point point1 = new Point(1.0, 2.0);
        Point point2 = new Point(2.0, 3.0);
        assertNotEquals(point1.hashCode(), point2.hashCode());
    }

    @Test
    void testToString() {
        Point point = new Point(1.0, 2.0);
        assertEquals("Point(1.0, 2.0)", point.toString());
    }
}
