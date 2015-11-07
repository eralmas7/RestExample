package com.assignment.validator;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.assignment.exception.InvalidResponseException;
import com.assignment.response.model.PositionDetails;

/**
 * Validator to validate we have valid response from GoEuro.
 */
public class GoEuroResponseValidator implements Validator<ResponseEntity<List<PositionDetails>>> {

    private Validator<ResponseEntity<List<PositionDetails>>> validator;

    public GoEuroResponseValidator(Validator<ResponseEntity<List<PositionDetails>>> validator) {
        this.validator = validator;
    }

    @Override
    public void validate(final ResponseEntity<List<PositionDetails>> goUserSuggestionResponse) {
        if (!goUserSuggestionResponse.hasBody()) {
            throw new InvalidResponseException("Got an empty response from goeuro");
        }
        validator.validate(goUserSuggestionResponse);
    }
}
