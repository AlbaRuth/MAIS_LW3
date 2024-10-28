package org.example.entity;

import org.example.exceptions.TriangleCreationException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void testTriangleCreation() {
        Point a = new Point(1.0, 2.0);
        Point b = new Point(3.0, 4.0);
        Point c = new Point(5.0, 6.0);
        int id = 1;

        Triangle triangle = new Triangle(a, b, c, id);

        assertEquals(a, triangle.getPointA());
        assertEquals(b, triangle.getPointB());
        assertEquals(c, triangle.getPointC());
        assertEquals(id, triangle.getName());
    }

    @Test
    void testEqualsSameTriangle() {
        Triangle triangle1 = new Triangle(new Point(1.0, 2.0), new Point(3.0, 4.0), new Point(5.0, 6.0), 1);
        Triangle triangle2 = new Triangle(new Point(1.0, 2.0), new Point(3.0, 4.0), new Point(5.0, 6.0), 1);

        assertEquals(triangle1, triangle2);
    }

    @Test
    void testEqualsDifferentTriangles() {
        Triangle triangle1 = new Triangle(new Point(1.0, 2.0), new Point(3.0, 4.0), new Point(5.0, 6.0), 1);
        Triangle triangle2 = new Triangle(new Point(1.0, 2.0), new Point(3.0, 4.0), new Point(7.0, 8.0), 2);

        assertNotEquals(triangle1, triangle2);
    }

    @Test
    void testEqualsWithNull() {
        Triangle triangle = new Triangle(new Point(1.0, 2.0), new Point(3.0, 4.0), new Point(5.0, 6.0), 1);

        assertNotEquals(triangle, null);
    }

    @Test
    void testEqualsWithDifferentClass() {
        Triangle triangle = new Triangle(new Point(1.0, 2.0), new Point(3.0, 4.0), new Point(5.0, 6.0), 1);
        String notATriangle = "Not a Triangle";

        assertNotEquals(triangle, notATriangle);
    }

    @Test
    void testHashCodeSameTriangles() {
        Triangle triangle1 = new Triangle(new Point(1.0, 2.0), new Point(3.0, 4.0), new Point(5.0, 6.0), 1);
        Triangle triangle2 = new Triangle(new Point(1.0, 2.0), new Point(3.0, 4.0), new Point(5.0, 6.0), 1);

        assertEquals(triangle1.hashCode(), triangle2.hashCode());
    }

    @Test
    void testHashCodeDifferentTriangles() {
        Triangle triangle1 = new Triangle(new Point(1.0, 2.0), new Point(3.0, 4.0), new Point(5.0, 6.0), 1);
        Triangle triangle2 = new Triangle(new Point(1.0, 2.0), new Point(3.0, 4.0), new Point(7.0, 8.0), 2);

        assertNotEquals(triangle1.hashCode(), triangle2.hashCode());
    }

    @Test
    void testToString() {
        Triangle triangle = new Triangle(new Point(1.0, 2.0), new Point(3.0, 4.0), new Point(5.0, 6.0), 1);
        assertEquals("Triangle(1): Point(1.0, 2.0), Point(3.0, 4.0), Point(5.0, 6.0)", triangle.toString());
    }

    @Test
    void testCreateTriangleWithValidPoints() {
        Point a = new Point(1.0, 2.0);
        Point b = new Point(3.0, 4.0);
        Point c = new Point(5.0, 6.0);
        int id = 1;

        Triangle triangle = Triangle.createTriangle(Arrays.asList(a, b, c), id);

        assertNotNull(triangle);
        assertEquals(a, triangle.getPointA());
        assertEquals(b, triangle.getPointB());
        assertEquals(c, triangle.getPointC());
        assertEquals(id, triangle.getName());
    }

    @Test
    void testCreateTriangleWithInvalidNumberOfPoints() {
        Point a = new Point(1.0, 2.0);
        Point b = new Point(3.0, 4.0);
        int id = 1;

        Exception exception = assertThrows(TriangleCreationException.class, () -> Triangle.createTriangle(Arrays.asList(a, b), id));
        assertEquals("Ошибка создания треугольника: требуется ровно три точки", exception.getMessage());
    }

    @Test
    void testCreateTriangleWithNullPoints() {
        int id = 1;

        Exception exception = assertThrows(TriangleCreationException.class, () -> Triangle.createTriangle(null, id));
        assertEquals("Ошибка создания треугольника: требуется ровно три точки", exception.getMessage());
    }
}
