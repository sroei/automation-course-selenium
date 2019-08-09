package com.automation.core.components;

import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;
import com.automation.extensions.components.WebDriverExtensions;
import okhttp3.OkHttpClient;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;

public class FluentRest extends FluentBase {
    private final OkHttpClient httpClient;

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

    @Override
    <T> T generateObject(Class c, Logger logger)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return null;
    }
}
