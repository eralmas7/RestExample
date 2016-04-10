package com.assignment.print.factory;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class OutputPrinterFactory {

    public static Writer getWriter(OutputType outputType) throws IOException {
        switch (outputType) {
            case FILE:
                return new PrintWriter(new File(System.getProperty("goeuro.csv.filepath", "/tmp/output.csv")));
            default:
                return new PrintWriter(System.out);
        }
    }
}
