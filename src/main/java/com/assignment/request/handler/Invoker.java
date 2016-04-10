package com.assignment.request.handler;

import java.util.List;
import com.assignment.response.model.InputRequest;
import com.assignment.response.model.PositionDetails;

/**
 * An invoker which would process input request from client.
 */
public interface Invoker {

    /**
     * A delegator which is responsible to call request life cycle method to fetch position
     * information.
     * 
     * @param inputRequest
     * @return
     */
    public List<PositionDetails> invoke(final InputRequest inputRequest);
}
