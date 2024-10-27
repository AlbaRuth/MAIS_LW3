package org.example.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Point;
import org.example.entity.Triangle;

public class TriangleValidator {
    private static final Logger logger = LogManager.getLogger(TriangleValidator.class);
    private static final double EPSILON = 0.001;

    public static boolean validateTriangle(Triangle triangle) {
        logger.info("Проверка валидности треугольника: {}", triangle);
        double ab = distance(triangle.getPointA(), triangle.getPointB());
        double bc = distance(triangle.getPointB(), triangle.getPointC());
        double ca = distance(triangle.getPointC(), triangle.getPointA());

        // Проверка, что сумма двух сторон больше третьей
        if ((ab + bc <= ca + EPSILON) ||
                (ab + ca <= bc + EPSILON) ||
                (bc + ca <= ab + EPSILON)) {
            logger.error("Ошибка: Треугольник из таких точек невозможно создать. Стороны: AB={}, BC={}, CA={}", ab, bc, ca);
            return false;
        }

        logger.info("Треугольник валиден.");
        return true;
    }

    public static double distance(Point p1, Point p2) {
        double dist = Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
        logger.debug("Расстояние между {} и {}: {}", p1, p2, dist);
        return dist;
    }
}
