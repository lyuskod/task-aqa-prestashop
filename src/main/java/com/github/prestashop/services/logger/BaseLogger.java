package com.github.prestashop.services.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class BaseLogger {
    private final Logger log4j2;

    private BaseLogger(Logger logger) {
        this.log4j2 = logger;
    }

    public static BaseLogger getLogger(Class clazz) {
        return new BaseLogger(LogManager.getLogger(clazz));
    }

    public void debug(String message) {
        this.log4j2.debug(message);
    }

    public void warn(String message)
    {
        this.log4j2.warn(message);
    }

    public void info(String message) {
        this.log4j2.info(message);
    }

    public void error(String message)
    {
        this.log4j2.error(message);
    }
}
