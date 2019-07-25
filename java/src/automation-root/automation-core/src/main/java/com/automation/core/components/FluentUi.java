package com.automation.core.components;

import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;
import com.google.gson.reflect.TypeToken;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

public abstract class FluentUi implements Fluent {

    private final WebDriver driver;
    private final Logger logger;

    protected FluentUi(WebDriver driver) {
        this(driver, new TraceLogger());
    }

    protected FluentUi(WebDriver driver, Logger logger) {
        this.driver = driver;
        this.logger = logger;
    }

    public <T> T changeContext()
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // factory
        return generateObject(generateClass(), null);
    }

    public <T> T changeContext(Logger logger)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // factory
        return generateObject(generateClass(), logger);
    }

    public <T> T changeContext(String application)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // navigate
        driver.navigate().to(application);
        driver.manage().window().maximize();

        // factory
        return generateObject(generateClass(), null);
    }

    public <T> T changeContext(String application, Logger logger)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // navigation
        driver.navigate().to(application);
        driver.manage().window().maximize();

        // factory
        return generateObject(generateClass(), logger);
    }

    private <T> Class generateClass()
            throws ClassNotFoundException {
        // get type for generic
        Type t = new TypeToken<T>() {
        }.getType();

        // return generated class
        return Class.forName(t.getTypeName());
    }

    @SuppressWarnings("unchecked")
    private <T> T generateObject(Class c, Logger logger)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // get constructor
        Constructor<T> ctr = logger == null
                ? c.getDeclaredConstructor(WebDriver.class)
                : c.getDeclaredConstructor(WebDriver.class, Logger.class);

        // get arguments
        Object[] args = logger == null ? new Object[]{driver} : new Object[]{driver, logger};

        // return new object instance
        return ctr.newInstance(args);
    }
}