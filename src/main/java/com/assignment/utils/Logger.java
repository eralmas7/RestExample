package com.assignment.utils;

import java.io.PrintStream;

/**
 * Doubles of logger.
 * 
 * @author almass
 *
 */
public class Logger {

    private static Logger logger = new Logger();

    private Logger() {}

    public static Logger getLogger() {
        return logger;
    }

    private void log(final Level level, final Object msg) {
        level.getStream().println("[" + level + "]: " + msg);
    }

    public void debug(final Object msg) {
        log(Level.DEBUG, msg);
    }

    public void info(final Object msg) {
        log(Level.INFO, msg);
    }

    public void warn(final Object msg) {
        log(Level.WARN, msg);
    }

    public void error(final Object msg) {
        log(Level.ERROR, msg);
    }

    public void fatal(final Object msg) {
        log(Level.WARN, msg);
    }

    private enum Level {
        DEBUG(System.out), INFO(System.out), WARN(System.out), ERROR(System.err), FATAL(System.err);

        private final PrintStream out;

        private Level(final PrintStream out) {
            this.out = out;
        }

        public PrintStream getStream() {
            return this.out;
        }
    }
}
