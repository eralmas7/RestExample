package com.assignment.exception;

/**
 * An exception which will be thrown when input data would be invalid or input city is not provided.
 */
public class InvalidDataException extends RuntimeException { 

    private static final long serialVersionUID = -6087784269417000204L;

    public InvalidDataException(final String message) {
        super(message);
    }
}
