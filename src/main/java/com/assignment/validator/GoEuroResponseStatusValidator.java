package com.assignment.validator;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.assignment.exception.InvalidResponseException;
import com.assignment.response.model.PositionDetails;

/**
 * Validator which will validate status of request that we sent to GoEuro.
 */
public class GoEuroResponseStatusValidator implements Validator<ResponseEntity<List<PositionDetails>>> {

    private Validator<ResponseEntity<List<PositionDetails>>> validator;

    public GoEuroResponseStatusValidator(Validator<ResponseEntity<List<PositionDetails>>> validator) {
        this.validator = validator;
    }

    @Override
    public void validate(final ResponseEntity<List<PositionDetails>> goUserSuggestionResponse) {
        if (goUserSuggestionResponse.getStatusCode() != HttpStatus.OK) {
            throw new InvalidResponseException("Got invalid response from goeuro " + goUserSuggestionResponse.getStatusCode());
        }
        validator.validate(goUserSuggestionResponse);
    }
}
