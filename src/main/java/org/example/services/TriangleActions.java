package org.example.services;

import org.example.entity.Triangle;
import org.example.exceptions.TriangleFileException;

public class TriangleActions {

    private static final double EPSILON = 0.001;

    public static double calculatePerimeter(Triangle triangle) {
        if (!TriangleValidator.validateTriangle(triangle)) {
            throw new TriangleFileException("Невозможно вычислить периметр: недопустимый треугольник.");
        }

        double ab = TriangleValidator.distance(triangle.getPointA(), triangle.getPointB());
        double bc = TriangleValidator.distance(triangle.getPointB(), triangle.getPointC());
        double ca = TriangleValidator.distance(triangle.getPointC(), triangle.getPointA());

        return ab + bc + ca;
    }

    public static double calculateArea(Triangle triangle) {
        if (!TriangleValidator.validateTriangle(triangle)) {
            throw new TriangleFileException("Невозможно вычислить площадь: недопустимый треугольник.");
        }

        double ab = TriangleValidator.distance(triangle.getPointA(), triangle.getPointB());
        double bc = TriangleValidator.distance(triangle.getPointB(), triangle.getPointC());
        double ca = TriangleValidator.distance(triangle.getPointC(), triangle.getPointA());

        double semiPerimeter = (ab + bc + ca) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - ab) * (semiPerimeter - bc) * (semiPerimeter - ca));
    }

    public static boolean isEquilateral(Triangle triangle) {
        if (!TriangleValidator.validateTriangle(triangle)) {
            throw new TriangleFileException("Невозможно определить тип: недопустимый треугольник.");
        }

        double ab = TriangleValidator.distance(triangle.getPointA(), triangle.getPointB());
        double bc = TriangleValidator.distance(triangle.getPointB(), triangle.getPointC());
        double ca = TriangleValidator.distance(triangle.getPointC(), triangle.getPointA());

        return Math.abs(ab - bc) < EPSILON &&
                Math.abs(bc - ca) < EPSILON;
    }

    public static boolean isIsosceles(Triangle triangle) {
        if (!TriangleValidator.validateTriangle(triangle)) {
            throw new TriangleFileException("Невозможно определить тип: недопустимый треугольник.");
        }

        double ab = TriangleValidator.distance(triangle.getPointA(), triangle.getPointB());
        double bc = TriangleValidator.distance(triangle.getPointB(), triangle.getPointC());
        double ca = TriangleValidator.distance(triangle.getPointC(), triangle.getPointA());

        return Math.abs(ab - bc) < EPSILON ||
                Math.abs(bc - ca) < EPSILON ||
                Math.abs(ca - ab) < EPSILON;
    }

    public static boolean isRight(Triangle triangle) {
        if (!TriangleValidator.validateTriangle(triangle)) {
            throw new TriangleFileException("Невозможно определить тип: недопустимый треугольник.");
        }

        double ab = TriangleValidator.distance(triangle.getPointA(), triangle.getPointB());
        double bc = TriangleValidator.distance(triangle.getPointB(), triangle.getPointC());
        double ca = TriangleValidator.distance(triangle.getPointC(), triangle.getPointA());

        return isPythagoreanTriple(ab, bc, ca);
    }

    public static boolean isScalene(Triangle triangle) {
        if (!TriangleValidator.validateTriangle(triangle)) {
            throw new TriangleFileException("Невозможно определить тип: недопустимый треугольник.");
        }

        double ab = TriangleValidator.distance(triangle.getPointA(), triangle.getPointB());
        double bc = TriangleValidator.distance(triangle.getPointB(), triangle.getPointC());
        double ca = TriangleValidator.distance(triangle.getPointC(), triangle.getPointA());

        return !(isEquilateral(triangle) || isIsosceles(triangle));
    }

    private static boolean isPythagoreanTriple(double a, double b, double c) {
        // Сортировка сторон, чтобы определить гипотенузу
        double[] sides = {a, b, c};
        java.util.Arrays.sort(sides);

        // Проверка теоремы Пифагора: c^2 ≈ a^2 + b^2 с учетом EPSILON
        return Math.abs(sides[2] * sides[2] - (sides[0] * sides[0] + sides[1] * sides[1])) < EPSILON;
    }
}
