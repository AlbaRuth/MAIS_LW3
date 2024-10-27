package org.example.exceptions;

public class InvalidTriangleException extends RuntimeException {
    public InvalidTriangleException(String message) {
        super(message);
    }
}
