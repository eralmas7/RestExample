package com.assignment.request.handler;

import java.util.List;
import com.assignment.dao.SuggestionDao;
import com.assignment.response.model.PositionDetails;
import com.assignment.validator.Validator;

/**
 * Implementation of request handler.
 */
public class UserRequestHandler implements RequestHandler {

    private Validator<String[]> validator;
    private SuggestionDao suggestionDao;
    private PostProcessor postProcessor;

    public UserRequestHandler(final Validator<String[]> validator, final SuggestionDao suggestionDao, final PostProcessor postProcessor) {
        this.validator = validator;
        this.suggestionDao = suggestionDao;
        this.postProcessor = postProcessor;
    }

    @Override
    public void preProcess(final String[] request) {
        validator.validate(request);
    }

    @Override
    public List<PositionDetails> process(final String request) {
        final List<PositionDetails> goEuroSuggestionList = suggestionDao.getSuggestion(request);
        return goEuroSuggestionList;
    }

    @Override
    public void postProcess(final List<PositionDetails> suggestionList) {
        postProcessor.processRequest(suggestionList);
    }
}
