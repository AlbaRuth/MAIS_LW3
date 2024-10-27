package org.example.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Factories.TriangleFactory;
import org.example.entity.Point;
import org.example.entity.Triangle;
import org.example.exceptions.InvalidCoordinateFormatException;
import org.example.exceptions.TriangleCreationException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TriangleFileReader {
    private static final Logger logger = LogManager.getLogger(TriangleFileReader.class);

    public static Triangle readTriangleFromFile(String filePath) throws IOException {
        logger.info("Чтение файла треугольника из: {}", filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                logger.debug("Обработка строки: {}", line);
                Triangle triangle = parseLineAndCreateTriangle(line);
                if (triangle != null) {
                    logger.info("Успешно создан треугольник: {}", triangle);
                    return triangle;
                } else {
                    logger.warn("Недопустимый формат строки: {}", line);
                }
            }
        }
        logger.warn("Не удалось создать треугольник: все строки в файле неверны.");
        return null; // Возвращает null, если не удалось создать ни одного Triangle
    }

    private static Triangle parseLineAndCreateTriangle(String line) {
        String[] coordinates = line.trim().split("\\s+");

        // Проверяем, что строка содержит ровно 6 чисел
        if (coordinates.length != 6) {
            logger.error("Некорректное количество координат. Ожидалось 6, получено: {}", coordinates.length);
            throw new InvalidCoordinateFormatException("Некорректное количество координат. Ожидалось 6, получено: " + coordinates.length);
        }

        try {
            // Извлекаем координаты и создаем точки
            List<Point> points = new ArrayList<>();
            points.add(new Point(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1])));
            points.add(new Point(Double.parseDouble(coordinates[2]), Double.parseDouble(coordinates[3])));
            points.add(new Point(Double.parseDouble(coordinates[4]), Double.parseDouble(coordinates[5])));

            // Используем TriangleFactory для создания Triangle
            return TriangleFactory.createTriangle(points);

        } catch (NumberFormatException e) {
            logger.error("Ошибка при разборе координат: {}. Причина: {}", line, e.getMessage());
            throw new TriangleCreationException("Ошибка при разборе координат: " + line + ". Причина: " + e.getMessage());
        }
    }
}
