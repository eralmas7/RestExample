package com.assignment.validator;

import org.apache.commons.lang.StringUtils;
import com.assignment.exception.InvalidDataException;
import com.assignment.response.model.InputRequest;

/**
 * Validate whether the input city is present or not.
 */
public class RequestedCityValidator implements Validator<InputRequest> {

    public void validate(final InputRequest inputRequest) {
        if (StringUtils.isEmpty(inputRequest.getCity())) {
            throw new InvalidDataException("Requested city can't be empty");
        }
    }
}
