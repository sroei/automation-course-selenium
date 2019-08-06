package com.automation.core.components;

import com.automation.core.logging.Logger;

import java.lang.reflect.InvocationTargetException;

public interface Fluent {
    <T> T changeContext(Class c, Logger logger)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    <T> T changeContext(Class c)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    <T> T changeContext(Class c, String application, Logger logger)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    <T> T changeContext(Class c, String application)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}