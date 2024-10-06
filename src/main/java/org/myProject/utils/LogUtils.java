package org.myProject.utils;

import org.myProject.enums.LogLevel;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class LogUtils {
    private static final Logger logger = getLogger(LogUtils.class.getSimpleName());;
    public static void info(String message) {
        logger.info(message);
    }
    public static void warn(String message) {
        logger.warn(message);
    }
    public static void warn(String message,Throwable t) {
        logger.warn(message,t);
    }

    public static void error(String message) {
        logger.error(message);
    }
    public static void error(String message,Throwable t) {
        logger.error(message,t);
    }

    public static void fatal(String message) {
        logger.error((message));
    }

    public static void debug(String message) {
        logger.debug(message);
    }
    public static void debug(String message, Throwable throwable) {
        logger.debug(message, throwable);
    }
    public static void trace(String message) {
        logger.trace(message);
    }

    public static void log(LogLevel level, String message) {
        switch (level) {
            case INFO:
                info(message);
                break;
            case WARN:
                warn(message);
                break;
            case ERROR:
                error(message);
                break;
            case FATAL:
                fatal(message);
                break;
            case TRACE:
                trace(message);
                break;
            case DEBUG:
                debug(message);
                break;
        }
    }
}
