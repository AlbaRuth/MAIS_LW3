package org.example.services;

import org.example.entity.Point;
import org.example.entity.Triangle;
import org.example.exceptions.TriangleFileException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleActionsTest {

    @Test
    void calculatePerimeter_ValidTriangle_ReturnsCorrectPerimeter() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4), 1);
        double expectedPerimeter = 3 + 4 + 5; // Периметр прямоугольного треугольника
        assertEquals(expectedPerimeter, TriangleActions.calculatePerimeter(triangle), 0.001);
    }

    @Test
    void calculatePerimeter_InvalidTriangle_ThrowsException() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(1, 1), new Point(2, 2), 1); // Точки на одной линии
        assertThrows(TriangleFileException.class, () -> TriangleActions.calculatePerimeter(triangle));
    }

    @Test
    void calculateArea_ValidTriangle_ReturnsCorrectArea() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4), 1);
        double expectedArea = 6; // Площадь прямоугольного треугольника
        assertEquals(expectedArea, TriangleActions.calculateArea(triangle), 0.001);
    }

    @Test
    void calculateArea_InvalidTriangle_ThrowsException() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(1, 1), new Point(2, 2), 1); // Точки на одной линии
        assertThrows(TriangleFileException.class, () -> TriangleActions.calculateArea(triangle));
    }

    @Test
    void isEquilateral_EquilateralTriangle_ReturnsTrue() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(1, Math.sqrt(3)), new Point(2, 0), 1);
        assertTrue(TriangleActions.isEquilateral(triangle));
    }

    @Test
    void isEquilateral_NotEquilateralTriangle_ReturnsFalse() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4), 1);
        assertFalse(TriangleActions.isEquilateral(triangle));
    }

    @Test
    void isIsosceles_IsoscelesTriangle_ReturnsTrue() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(2, 0), new Point(1, Math.sqrt(3)), 1);
        assertTrue(TriangleActions.isIsosceles(triangle));
    }

    @Test
    void isIsosceles_NotIsoscelesTriangle_ReturnsFalse() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4), 1);
        assertFalse(TriangleActions.isIsosceles(triangle));
    }

    @Test
    void isRight_RightTriangle_ReturnsTrue() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4), 1);
        assertTrue(TriangleActions.isRight(triangle));
    }

    @Test
    void isRight_NotRightTriangle_ReturnsFalse() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(1, 1), new Point(2, 1), 1); // Измененные координаты
        assertFalse(TriangleActions.isRight(triangle));
    }


    @Test
    void isScalene_ScaleneTriangle_ReturnsTrue() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(4, 0), new Point(0, 5), 1);
        assertTrue(TriangleActions.isScalene(triangle));
    }

    @Test
    void isScalene_NotScaleneTriangle_ReturnsFalse() {
        Triangle triangle = new Triangle(new Point(0, 0), new Point(1, Math.sqrt(3)), new Point(2, 0), 1); // Равносторонний
        assertFalse(TriangleActions.isScalene(triangle));
    }
}
