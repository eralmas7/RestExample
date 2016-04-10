package com.assignment.request.handler;

import java.util.List;
import com.assignment.response.model.InputRequest;
import com.assignment.response.model.PositionDetails;

/**
 * Actual invoker which would process input request from client.
 */
public class RequestInvoker implements Invoker {

    private RequestHandler requestHandler;

    public RequestInvoker(final RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    @Override
    public List<PositionDetails> invoke(final InputRequest inputRequest) {
        requestHandler.preProcess(inputRequest);
        final List<PositionDetails> suggestionList = requestHandler.process(inputRequest);
        requestHandler.postProcess(suggestionList);
        return suggestionList;
    }
}
