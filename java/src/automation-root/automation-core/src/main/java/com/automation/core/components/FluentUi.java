package com.automation.core.components;

import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;
import com.automation.extensions.components.WebDriverExtensions;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class FluentUi implements Fluent {

    private final WebDriver driver;
    private final Logger logger;
    private WebDriverExtensions driverExtensions;

    public FluentUi(WebDriver driver) {
        this(driver, new TraceLogger());
    }

    public FluentUi(WebDriver driver, Logger logger) {
        this.driver = driver;
        this.logger = logger;
        driverExtensions = new WebDriverExtensions(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Logger getLogger() {
        return logger;
    }

    public WebDriverExtensions getDriverExtensions(){
        return driverExtensions;
    }

    public <T> T changeContext(Class c)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // factory
        return generateObject(c, null);
    }

    public <T> T changeContext(Class c, Logger logger)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // factory
        return generateObject(c, logger);
    }

    public <T> T changeContext(Class c, String application)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // navigate
        driver.navigate().to(application);
        driver.manage().window().maximize();

        // factory
        return generateObject(c, null);
    }

    public <T> T changeContext(Class c, String application, Logger logger)
            throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // navigation
        driver.navigate().to(application);
        driver.manage().window().maximize();

        // factory
        return generateObject(c, logger);
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