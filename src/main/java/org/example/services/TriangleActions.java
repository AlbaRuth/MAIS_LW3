package org.example.services;

import org.example.entity.Triangle;
import org.example.exceptions.TriangleFileException;

public class TriangleActions {

    private static final double EPSILON = 0.001;

    /**
     * Вычисляет периметр треугольника.
     * @param triangle треугольник для расчета
     * @return периметр треугольника
     * @throws TriangleFileException если треугольник недопустимый
     */
    public static double calculatePerimeter(Triangle triangle) {
        if (!TriangleValidator.validateTriangle(triangle)) {
            throw new TriangleFileException("Невозможно вычислить периметр: недопустимый треугольник.");
        }
        double ab = TriangleValidator.distance(triangle.getPointA(), triangle.getPointB());
        double bc = TriangleValidator.distance(triangle.getPointB(), triangle.getPointC());
        double ca = TriangleValidator.distance(triangle.getPointC(), triangle.getPointA());
        return ab + bc + ca;
    }

    /**
     * Вычисляет площадь треугольника.
     * @param triangle треугольник для расчета
     * @return площадь треугольника
     * @throws TriangleFileException если треугольник недопустимый
     */
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

    /**
     * Проверяет, является ли треугольник равносторонним.
     * @param triangle треугольник для проверки
     * @return true, если треугольник равносторонний
     * @throws TriangleFileException если треугольник недопустимый
     */
    public static boolean isEquilateral(Triangle triangle) {
        if (!TriangleValidator.validateTriangle(triangle)) {
            throw new TriangleFileException("Невозможно определить тип: недопустимый треугольник.");
        }
        double ab = TriangleValidator.distance(triangle.getPointA(), triangle.getPointB());
        double bc = TriangleValidator.distance(triangle.getPointB(), triangle.getPointC());
        double ca = TriangleValidator.distance(triangle.getPointC(), triangle.getPointA());
        return Math.abs(ab - bc) < EPSILON && Math.abs(bc - ca) < EPSILON;
    }

    /**
     * Проверяет, является ли треугольник равнобедренным.
     * @param triangle треугольник для проверки
     * @return true, если треугольник равнобедренный
     * @throws TriangleFileException если треугольник недопустимый
     */
    public static boolean isIsosceles(Triangle triangle) {
        if (!TriangleValidator.validateTriangle(triangle)) {
            throw new TriangleFileException("Невозможно определить тип: недопустимый треугольник.");
        }
        double ab = TriangleValidator.distance(triangle.getPointA(), triangle.getPointB());
        double bc = TriangleValidator.distance(triangle.getPointB(), triangle.getPointC());
        double ca = TriangleValidator.distance(triangle.getPointC(), triangle.getPointA());
        return Math.abs(ab - bc) < EPSILON || Math.abs(bc - ca) < EPSILON || Math.abs(ca - ab) < EPSILON;
    }

    /**
     * Проверяет, является ли треугольник прямоугольным.
     * @param triangle треугольник для проверки
     * @return true, если треугольник прямоугольный
     * @throws TriangleFileException если треугольник недопустимый
     */
    public static boolean isRight(Triangle triangle) {
        if (!TriangleValidator.validateTriangle(triangle)) {
            throw new TriangleFileException("Невозможно определить тип: недопустимый треугольник.");
        }
        double ab = TriangleValidator.distance(triangle.getPointA(), triangle.getPointB());
        double bc = TriangleValidator.distance(triangle.getPointB(), triangle.getPointC());
        double ca = TriangleValidator.distance(triangle.getPointC(), triangle.getPointA());
        return isPythagoreanTriple(ab, bc, ca);
    }

    /**
     * Проверяет, является ли треугольник разносторонним.
     * @param triangle треугольник для проверки
     * @return true, если треугольник разносторонний
     * @throws TriangleFileException если треугольник недопустимый
     */
    public static boolean isScalene(Triangle triangle) {
        if (!TriangleValidator.validateTriangle(triangle)) {
            throw new TriangleFileException("Невозможно определить тип: недопустимый треугольник.");
        }
        double ab = TriangleValidator.distance(triangle.getPointA(), triangle.getPointB());
        double bc = TriangleValidator.distance(triangle.getPointB(), triangle.getPointC());
        double ca = TriangleValidator.distance(triangle.getPointC(), triangle.getPointA());
        return !(isEquilateral(triangle) || isIsosceles(triangle));
    }

    /**
     * Проверяет, соответствует ли треугольник условию Пифагора для прямоугольного треугольника.
     * @param a длина первой стороны
     * @param b длина второй стороны
     * @param c длина третьей стороны
     * @return true, если выполняется теорема Пифагора
     */
    private static boolean isPythagoreanTriple(double a, double b, double c) {
        double[] sides = {a, b, c};
        java.util.Arrays.sort(sides);
        return Math.abs(sides[2] * sides[2] - (sides[0] * sides[0] + sides[1] * sides[1])) < EPSILON;
    }
}
