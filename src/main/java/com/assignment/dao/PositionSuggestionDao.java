package com.assignment.dao;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.assignment.response.model.InputRequest;
import com.assignment.response.model.PositionDetails;
import com.assignment.validator.Validator;

/**
 * Data access object to get position data from goeuro endpoint based on requested city.
 */
public class PositionSuggestionDao implements SuggestionDao {

    private final RestTemplate restTemplate;
    private static final String POSITION_SUGGESSTION_URL = System.getProperty("goeuro.repository.url");
    private final List<Validator<ResponseEntity<List<PositionDetails>>>> validatorList;

    public PositionSuggestionDao(final RestTemplate restTemplate, final List<Validator<ResponseEntity<List<PositionDetails>>>> validatorList) {
        this.restTemplate = restTemplate;
        this.validatorList = validatorList;
    }

    @Override
    public List<PositionDetails> getSuggestion(final InputRequest inputRequest) {
        final ResponseEntity<List<PositionDetails>> goEuroResponseEntity = restTemplate.exchange(POSITION_SUGGESSTION_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<PositionDetails>>() {}, inputRequest.getCity());
        validatorList.forEach(validator -> validator.validate(goEuroResponseEntity));
        return goEuroResponseEntity.getBody();
    }
}
