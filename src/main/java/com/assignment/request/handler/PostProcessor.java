package com.assignment.request.handler;

import java.util.List;
import com.assignment.response.model.PositionDetails;

/**
 * A post processor which is responsible to process position information that we get from data
 * store.
 */
public interface PostProcessor {

    /**
     * Based on input list returned from data store, we might need to write to file or print
     * suggestion on console.
     * 
     * @param suggestionList
     */
    public void processRequest(final List<PositionDetails> suggestionList);
}
