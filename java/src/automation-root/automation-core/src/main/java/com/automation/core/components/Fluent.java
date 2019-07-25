package com.automation.core.components;

import java.lang.reflect.InvocationTargetException;

public interface Fluent {
    <T> T changeContext() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

    <T> T changeContext(String application) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}