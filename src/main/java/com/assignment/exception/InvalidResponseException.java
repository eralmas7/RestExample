package com.assignment.exception;

/**
 * An exception which will be thrown when we fail to get data from data repository.
 */
public class InvalidResponseException extends RuntimeException {

    private static final long serialVersionUID = -6087784269417000204L;

    public InvalidResponseException(final String message) {
        super(message);
    }
}
