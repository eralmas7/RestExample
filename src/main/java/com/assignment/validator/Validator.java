package com.assignment.validator;

/**
 * Validator to validate user input or output.
 * 
 * @param <T>
 */
public interface Validator<T> {

    /**
     * Validate input parameter.
     * 
     * @param userInput
     */
    public void validate(final T input);
}
