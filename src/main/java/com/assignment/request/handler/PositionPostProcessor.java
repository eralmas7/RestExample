package com.assignment.request.handler;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import com.assignment.exception.DataWriterException;
import com.assignment.print.factory.OutputPrinterFactory;
import com.assignment.print.factory.OutputType;
import com.assignment.response.model.PositionDetails;

/**
 * Post processor to print the data in csv format onto console/file.
 */
public class PositionPostProcessor implements PostProcessor {

    private final static OutputType outputType = OutputType.valueOf(System.getProperty("goeuro.assignment.outputType", "CONSOLE"));

    @Override
    public void processRequest(final List<PositionDetails> suggestionList) {
        try (final Writer writer = OutputPrinterFactory.getWriter(outputType)) {
            for (PositionDetails positionDetails : suggestionList) {
                writer.write(positionDetails.getCsvString() + System.getProperty("line.separator"));
            }
        } catch (IOException ioException) {
            throw new DataWriterException("It seems either file is not present or it doesnt have write permission", ioException);
        }
    }
}
