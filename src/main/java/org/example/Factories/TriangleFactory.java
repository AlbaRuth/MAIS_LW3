package org.example.Factories;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Point;
import org.example.entity.Triangle;
import org.example.exceptions.IncorrectNumberOfPointsHasBeenReceivedAtTheInputException;

import java.util.List;

public class TriangleFactory {
    private static final Logger logger = LogManager.getLogger(TriangleFactory.class);
    private static int id_counter = 1;

    public static Triangle createTriangle(List<Point> points) {
        if (points == null || points.size() != 3) {
            logger.error("Ошибка: количество точек некорректно. Получено: {}", points == null ? "null" : points.size());
            throw new IncorrectNumberOfPointsHasBeenReceivedAtTheInputException("Требуется ровно три точки для создания треугольника.");
        }

        Triangle triangle = Triangle.createTriangle(points, id_counter);
        logger.info("Создан треугольник с ID {}: {}", id_counter, triangle);
        id_counter++; // Увеличиваем счётчик для следующего треугольника
        return triangle;
    }

    // Метод для сброса счётчика (опционально, если нужно)
    public static void resetCounter() {
        logger.info("Сброс счетчика ID треугольника с текущего значения: {}", id_counter);
        id_counter = 1;
        logger.info("Счетчик ID успешно сброшен на 1");
    }
}
