package com.assignment.request.handler;

import java.util.List;
import com.assignment.dao.SuggestionDao;
import com.assignment.response.model.InputRequest;
import com.assignment.response.model.PositionDetails;
import com.assignment.validator.Validator;

/**
 * Implementation of request handler.
 */
public class UserRequestHandler implements RequestHandler {

    private List<Validator<InputRequest>> validatorList;
    private SuggestionDao suggestionDao;
    private PostProcessor postProcessor;

    public UserRequestHandler(final List<Validator<InputRequest>> validatorList, final SuggestionDao suggestionDao, final PostProcessor postProcessor) {
        this.validatorList = validatorList;
        this.suggestionDao = suggestionDao;
        this.postProcessor = postProcessor;
    }

    @Override
    public void preProcess(final InputRequest inputRequest) {
        validatorList.forEach(validator -> validator.validate(inputRequest));
    }

    @Override
    public List<PositionDetails> process(final InputRequest inputRequest) {
        final List<PositionDetails> goEuroSuggestionList = suggestionDao.getSuggestion(inputRequest);
        return goEuroSuggestionList;
    }

    @Override
    public void postProcess(final List<PositionDetails> suggestionList) {
        postProcessor.processRequest(suggestionList);
    }
}
