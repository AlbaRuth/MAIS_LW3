
import org.example.entity.Point;
import org.example.entity.Triangle;
import org.example.services.TriangleValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleValidatorTest {

    @Test
    void testValidTriangle() {
        Triangle triangle = new Triangle(new Point(0.0, 0.0), new Point(3.0, 0.0), new Point(0.0, 4.0), 1);
        assertTrue(TriangleValidator.validateTriangle(triangle), "Треугольник должен быть валидным");
    }

    @Test
    void testInvalidTriangleWithCollinearPoints() {
        Triangle triangle = new Triangle(new Point(0.0, 0.0), new Point(1.0, 1.0), new Point(2.0, 2.0), 2);
        assertFalse(TriangleValidator.validateTriangle(triangle), "Треугольник с коллинеарными точками не должен быть валидным");
    }

    @Test
    void testInvalidTriangleWithSumOfSidesNotGreaterThanThird() {
        Triangle triangle = new Triangle(new Point(0.0, 0.0), new Point(1.0, 0.0), new Point(2.0, 0.0), 3);
        assertFalse(TriangleValidator.validateTriangle(triangle), "Треугольник, где сумма двух сторон не больше третьей, не должен быть валидным");
    }

    @Test
    void testDistanceCalculation() {
        Point p1 = new Point(0.0, 0.0);
        Point p2 = new Point(3.0, 4.0);
        double expectedDistance = 5.0;
        assertEquals(expectedDistance, TriangleValidator.distance(p1, p2), 0.001, "Расстояние между точками рассчитано неверно");
    }

    @Test
    void testDistanceCalculationWithSamePoint() {
        Point p1 = new Point(1.0, 1.0);
        assertEquals(0.0, TriangleValidator.distance(p1, p1),0.001, "Расстояние между одинаковыми точками должно быть равно 0");
    }
}
