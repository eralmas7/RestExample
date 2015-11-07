package com.assignment.validator;

import org.apache.commons.lang.StringUtils;
import com.assignment.exception.InvalidDataException;

/**
 * Validate whether the input city is present or not.
 */
public class RequestedCityValidator implements Validator<String[]> {

    private final Validator<String[]> validator;

    public RequestedCityValidator(Validator<String[]> validator) {
        this.validator = validator;
    }

    public void validate(final String request[]) {
        if (StringUtils.isEmpty(request[0])) {
            throw new InvalidDataException("Request data can't be empty");
        }
        validator.validate(request);
    }
}
