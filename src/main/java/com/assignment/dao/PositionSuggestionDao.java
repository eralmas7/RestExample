package com.assignment.dao;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.assignment.response.model.PositionDetails;
import com.assignment.validator.Validator;

/**
 * Data access object to get position data from goeuro endpoint based on requested city.
 */
public class PositionSuggestionDao implements SuggestionDao {

    private final RestTemplate restTemplate;
    private static final String POSITION_SUGGESSTION_URL = System.getProperty("goeuro.repository.url");
    private final Validator<ResponseEntity<List<PositionDetails>>> validator;

    public PositionSuggestionDao(final RestTemplate restTemplate, final Validator<ResponseEntity<List<PositionDetails>>> validator) {
        this.restTemplate = restTemplate;
        this.validator = validator;
    }

    @Override
    public List<PositionDetails> getSuggestion(final String requestCity) {
        final ResponseEntity<List<PositionDetails>> goEuroResponseEntity = restTemplate.exchange(POSITION_SUGGESSTION_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<PositionDetails>>() {}, requestCity);
        validator.validate(goEuroResponseEntity);
        return goEuroResponseEntity.getBody();
    }
}
