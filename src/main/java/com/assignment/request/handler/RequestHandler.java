package com.assignment.request.handler;

import java.util.List;
import com.assignment.response.model.PositionDetails;

/**
 * Handler responsible for handling client request.
 */
public interface RequestHandler {

    /**
     * Preprocess request. This method would be responsible for things that should happen before we
     * process the request viz. unmarshalling input information or validating input data.
     * 
     * @param request
     */
    public void preProcess(final String[] request);

    /**
     * Process the actual request now. Here we will actually goto data store to fetch the data.
     * 
     * @param request
     * @return
     */
    public List<PositionDetails> process(final String request);

    /**
     * Post process request. This method is responsible for proessing data returned from data store
     * viz. emailing data to user or saving data in a csv file or print the data in file.
     * 
     * @param goEuroSuggestionList
     */
    public void postProcess(final List<PositionDetails> goEuroSuggestionList);
}
