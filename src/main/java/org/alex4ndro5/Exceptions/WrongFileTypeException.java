package org.alex4ndro5.Exceptions;

public class WrongFileTypeException extends RuntimeException {
    public WrongFileTypeException(String message) {
        super(message);
    }
}
