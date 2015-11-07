package com.assignment.request.handler;

import java.util.List;
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
    public List<PositionDetails> invoke(final String[] request) {
        requestHandler.preProcess(request);
        final List<PositionDetails> suggestionList = requestHandler.process(request[0]);
        requestHandler.postProcess(suggestionList);
        return suggestionList;
    }
}
