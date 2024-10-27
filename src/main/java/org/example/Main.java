package org.example;

import org.example.FileReader.TriangleFileReader;
import org.example.entity.Triangle;
import org.example.services.TriangleActions;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\memch\\Desktop\\MAIS_LW3\\src\\main\\resources\\input.txt";

        try {
            Triangle triangle = TriangleFileReader.readTriangleFromFile(filePath);
            if (triangle != null) {
                System.out.println("Треугольник успешно создан: " + triangle);

                double perimeter = TriangleActions.calculatePerimeter(triangle);
                double area = TriangleActions.calculateArea(triangle);

                System.out.println("Периметр треугольника: " + perimeter);
                System.out.println("Площадь треугольника: " + area);

                // Определение типа треугольника
                if (TriangleActions.isEquilateral(triangle)) {
                    System.out.println("Треугольник является равносторонним.");
                } else if (TriangleActions.isIsosceles(triangle)) {
                    System.out.println("Треугольник является равнобедренным.");
                } else if (TriangleActions.isRight(triangle)) {
                    System.out.println("Треугольник является прямоугольным.");
                } else if (TriangleActions.isScalene(triangle)) {
                    System.out.println("Треугольник является произвольным (разносторонним).");
                }
            } else {
                System.out.println("Не удалось создать треугольник: неверные или неполные данные в файле.");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
