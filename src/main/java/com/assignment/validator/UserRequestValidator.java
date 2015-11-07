package com.assignment.validator;

import com.assignment.exception.InvalidDataException;

/**
 * Validator to validate input if its passed or not.
 */
public class UserRequestValidator implements Validator<String[]> {

    private final Validator<String[]> validator;

    public UserRequestValidator(Validator<String[]> validator) {
        this.validator = validator;
    }

    public void validate(final String request[]) {
        if (request == null || request.length == 0) {
            throw new InvalidDataException("You need to pass atleast one argument which represents name of city");
        }
        validator.validate(request);
    }
}
