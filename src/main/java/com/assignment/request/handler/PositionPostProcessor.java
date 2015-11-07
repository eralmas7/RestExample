package com.assignment.request.handler;

import java.util.List;
import com.assignment.response.model.PositionDetails;

/**
 * Post processor to print the data in csv format onto console.
 */
public class PositionPostProcessor implements PostProcessor {

    @Override
    public void processRequest(final List<PositionDetails> suggestionList) {
        suggestionList.stream().forEach(System.out::println);
    }
}
