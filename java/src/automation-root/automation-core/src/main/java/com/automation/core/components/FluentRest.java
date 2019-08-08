package com.automation.core.components;

import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;
import com.automation.extensions.components.WebDriverExtensions;
import okhttp3.OkHttpClient;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;

public class FluentRest implements Fluent {
    private final OkHttpClient httpClient;
    private final Logger logger;

    public FluentRest(OkHttpClient httpClient) {
        this(httpClient, new TraceLogger());
    }

    public FluentRest(OkHttpClient httpClient, Logger logger) {
        this.httpClient = httpClient;
        this.logger = logger;
    }

    public OkHttpClient getHttpClient() {
        return httpClient;
    }

    public Logger getLogger() {
        return logger;
    }

    @Override
    public <T> T changeContext(Class c, Logger logger)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return null;
    }

    @Override
    public <T> T changeContext(Class c)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return null;
    }

    @Override
    public <T> T changeContext(Class c, String application, Logger logger)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return null;
    }

    @Override
    public <T> T changeContext(Class c, String application)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return null;
    }
}
