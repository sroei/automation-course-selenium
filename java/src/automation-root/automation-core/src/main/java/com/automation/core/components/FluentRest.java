package com.automation.core.components;

import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;
import com.automation.extensions.components.WebDriverExtensions;
import okhttp3.OkHttpClient;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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

    public OkHttpClient getHttpClient() {
        return httpClient;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public <T> T changeContext(Class c, String application, Logger logger)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // set base url
        baseUrl = application;

        // factory
        return generateObject(c, logger);
    }

    @Override
    public <T> T changeContext(Class c, String application)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
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
        Constructor<T> ctr = logger == null
                ? c.getDeclaredConstructor(OkHttpClient.class)
                : c.getDeclaredConstructor(OkHttpClient.class, Logger.class);

        // get arguments
        Object[] args = logger == null ? new Object[]{httpClient} : new Object[]{httpClient, logger};

        // return new object instance
        return ctr.newInstance(args);
    }
}