package org.example.exceptions;

public class InvalidCoordinateFormatException extends TriangleFileException {
    public InvalidCoordinateFormatException(String message) {
        super(message);
    }
}