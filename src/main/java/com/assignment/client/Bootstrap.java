package com.assignment.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.assignment.request.handler.Invoker;
import com.assignment.response.model.InputRequest;
import com.assignment.utils.Logger;

/**
 * Main class with entry point for client.
 */
public class Bootstrap {

    private static Logger logger = Logger.getLogger();

    /**
     * Entry point of the application.
     * 
     * @param args
     */
    public static void main(final String args[]) {
        usage(args);
        try (final ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("com.assignment.position.suggestor.xml")) {
            final Invoker requestInvoker = applicationContext.getBean("requestInvoker", Invoker.class);
            InputRequest inputRequest = new InputRequest(args[0]);
            requestInvoker.invoke(inputRequest);
        }
    }

    private static void usage(final String args[]) {
        if (args == null || args.length == 0) {
            logger.error("Incorrect usage of command line. We need to pass a city name");
            logger.info("Usage: java -jar GoEuroTest.jar <CITY_NAME>");
            System.exit(-1);
        }
    }
}
