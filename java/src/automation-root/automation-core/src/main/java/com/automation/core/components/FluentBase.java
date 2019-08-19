package com.automation.core.components;

import com.automation.core.logging.Logger;

import java.lang.reflect.InvocationTargetException;

@SuppressWarnings("WeakerAccess")
public abstract class FluentBase implements Fluent {
    private final Logger logger;

    public FluentBase(Logger logger) {
        this.logger = logger;
    }

    public Logger getLogger() {
        return logger;
    }

    @Override
    public <T> T changeContext(Class c)
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // factory
        return generateObject(c, null);
    }

    @Override
    public <T> T changeContext(Class c, Logger logger)
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // factory
        return generateObject(c, logger);
    }

    @Override
    public abstract <T> T changeContext(Class c, String application, Logger logger)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    @Override
    public abstract <T> T changeContext(Class c, String application)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    @Override
    public abstract <T> T changeContext(String type, String application)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    abstract <T> T generateObject(Class c, Logger logger)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}