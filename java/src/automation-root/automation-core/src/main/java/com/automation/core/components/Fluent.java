package com.automation.core.components;

import com.automation.core.logging.Logger;

import java.lang.reflect.InvocationTargetException;

public interface Fluent {
    <T> T changeContext(Logger logger)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    <T> T changeContext()
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    <T> T changeContext(String application, Logger logger)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    <T> T changeContext(String application)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}