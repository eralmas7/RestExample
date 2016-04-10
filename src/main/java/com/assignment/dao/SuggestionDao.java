package com.assignment.dao;

import java.util.List;
import com.assignment.response.model.InputRequest;
import com.assignment.response.model.PositionDetails;

/**
 * Data access object who will interact with data store to get position.
 */
public interface SuggestionDao {

    /**
     * Data access object to get position suggestion for cityName
     * 
     * @param inputRequest
     * @return
     */
    public List<PositionDetails> getSuggestion(final InputRequest inputRequest);
}
