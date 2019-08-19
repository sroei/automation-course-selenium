package com.automation.core.components;

import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;
import okhttp3.OkHttpClient;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@SuppressWarnings({"WeakerAccess", "unused"})
public class FluentRest extends FluentBase {
    private final OkHttpClient httpClient;
    private String baseUrl;

    public FluentRest(OkHttpClient httpClient) {
        this(httpClient, new TraceLogger());
    }

    public FluentRest(OkHttpClient httpClient, Logger logger) {
        super(logger);
        this.httpClient = httpClient;
    }

    public FluentRest(OkHttpClient httpClient, Logger logger, String baseUrl) {
        super(logger);
        this.httpClient = httpClient;
        this.baseUrl = baseUrl;
    }

    public OkHttpClient getHttpClient() {
        return httpClient;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public <T> T changeContext(Class c, String application, Logger logger)
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // set base url
        baseUrl = application;

        // factory
        return generateObject(c, logger);
    }

    @Override
    public <T> T changeContext(Class c, String application)
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // set base url
        baseUrl = application;

        // factory
        return generateObject(c, null);
    }

    @Override
    public <T> T changeContext(String type, String application)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // generate class
        Class c = Class.forName(type);

        // set base url
        baseUrl = application;

        // factory
        return generateObject(c, null);
    }

    @SuppressWarnings("unchecked")
    @Override
    <T> T generateObject(Class c, Logger logger)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // get constructor
        Constructor<T> ctr = c.getDeclaredConstructor(OkHttpClient.class, Logger.class, String.class);
        ctr.setAccessible(true);

        // get arguments
        Object[] args = new Object[]{httpClient, logger, baseUrl};

        // return new object instance
        return ctr.newInstance(args);
    }
}