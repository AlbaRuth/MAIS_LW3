package org.example.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.exceptions.TriangleCreationException;

import java.util.List;

public class Triangle {
    private static final Logger logger = LogManager.getLogger(Triangle.class);

    private final Point pointA;
    private final Point pointB;
    private final Point pointC;
    private final int id_t;

    public Triangle(Point pointA, Point pointB, Point pointC, int id_t) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.id_t = id_t;
        logger.info("Создан треугольник: {}", this);
    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public int getName() {
        return id_t;
    }

    @Override
    public String toString() {
        return "Triangle(" + id_t + "): " + pointA + ", " + pointB + ", " + pointC;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Triangle triangle = (Triangle) obj;
        return pointA.equals(triangle.pointA) && pointB.equals(triangle.pointB) && pointC.equals(triangle.pointC);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + pointA.hashCode();
        result = 31 * result + pointB.hashCode();
        result = 31 * result + pointC.hashCode();
        return result;
    }

    // Static factory method to create a Triangle from a list of points
    public static Triangle createTriangle(List<Point> points, int id_t) {
        if (points == null || points.size() != 3) {
            logger.error("Ошибка создания треугольника: требуется ровно три точки, получено {}", points == null ? "null" : points.size());
            throw new TriangleCreationException("Ошибка создания треугольника: требуется ровно три точки");
        }
        Triangle triangle = new Triangle(points.get(0), points.get(1), points.get(2), id_t);
        logger.info("Треугольник успешно создан: {}", triangle);
        return triangle;
    }
}
