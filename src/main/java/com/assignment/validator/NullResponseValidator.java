package com.assignment.validator;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.assignment.response.model.PositionDetails;

/**
 * End of chain of validator for response that we get from GoEuro.
 */
public class NullResponseValidator implements Validator<ResponseEntity<List<PositionDetails>>> {

    public void validate(final ResponseEntity<List<PositionDetails>> goUserSuggestionResponse) {}
}
