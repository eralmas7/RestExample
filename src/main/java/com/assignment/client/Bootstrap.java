package com.assignment.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.assignment.request.handler.Invoker;

/**
 * Main class with entry point for client.
 */
public class Bootstrap {

    /**
     * Entry point of the application.
     * 
     * @param args
     */
    public static void main(final String args[]) {
        try (final ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("com.assignment.position.suggestor.xml")) {
            final Invoker requestInvoker = applicationContext.getBean("requestInvoker", Invoker.class);
            requestInvoker.invoke(args);
        }
    }
}
