package com.automation.core.testing;

import com.automation.core.components.Fluent;
import com.automation.core.components.FluentBase;
import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;
import com.automation.extensions.components.WebDriverFactory;
import com.automation.extensions.contracts.DriverParams;
import okhttp3.OkHttpClient;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"unused", "WeakerAccess"})
public abstract class TestCase {

    // fields
    private Map<String, Object> testParams;
    private int attempts;
    private Logger logger;
    private boolean actual;
    private WebDriver driver;
    private OkHttpClient httpClient;

    protected TestCase() {
        testParams = new HashMap<>();
        attempts = 1;
        logger = new TraceLogger();
        actual = false;
    }

    // components
    public abstract boolean automationTest(Map<String, Object> testParams) throws
            IOException,
            ClassNotFoundException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException;

    public final TestCase invoke() throws MalformedURLException {
        for (int i = 0; i < attempts; i++) {
            setup();
            try {
                actual = automationTest(testParams);
                if (actual) {
                    return this;
                }
                logger.debug(String.format("[%s] failed on attempt [%d]", getClass().getName(), i));
            } catch (NotImplementedException e) {
                logger.debug(e, e.getMessage());
                return this;
            } catch (NullPointerException e) {
                logger.debug(e, e.toString());
                return this;
            } catch (Exception e) {
                logger.debug(e, e.getMessage());
            } finally {
                cleanup();
            }
        }
        return this;
    }

    // properties - get actual
    public final boolean getActual() {
        return actual;
    }

    public final WebDriver getDriver() {
        return driver;
    }

    public final OkHttpClient getHttpClient() {
        return httpClient;
    }

    // configurations
    public final TestCase setTestParams(Map<String, Object> testParams) {
        this.testParams = testParams;
        return this;
    }

    public final TestCase setNumberOfAttempts(int numberOfAttempts) {
        this.attempts = numberOfAttempts;
        return this;
    }

    public final TestCase setLogger(Logger logger) {
        this.logger = logger;
        return this;
    }

    // factory
    public final Fluent newFluentApi(String type) throws
            ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        // extracting class
        Class<?> t = Class.forName(type);

        // extract constructors
        Constructor<?>[] ctr = t.getConstructors();

        // setup conditions
        boolean isFluent = FluentBase.class.isAssignableFrom(t);
        boolean isRest = isFluent && Arrays.stream(ctr).anyMatch(c -> Arrays.stream(c.getParameterTypes()).anyMatch(p -> p == OkHttpClient.class));
        boolean isFront = isFluent && Arrays.stream(ctr).anyMatch(c -> Arrays.stream(c.getParameterTypes()).anyMatch(p -> p == WebDriver.class));

        // factoring
        if (isRest) {
            return (Fluent) t.getDeclaredConstructor(OkHttpClient.class, Logger.class).newInstance(httpClient, logger);
        } else if (isFront) {
            return (Fluent) t.getDeclaredConstructor(WebDriver.class, Logger.class).newInstance(driver, logger);
        }
        throw new ClassNotFoundException("implementation of " + type + " was not found");
    }

    // setup
    protected void onSetup() {

    }

    private void setup() throws MalformedURLException {
        // constants
        final String DRIVER = "driver";
        final String BINARIES = "driverBinaries";

        // default
        DriverParams driverParams = new DriverParams().setDriver("CHROME").setBinaries(".");

        // set driver if exists
        boolean isDriver = testParams != null && testParams.containsKey(DRIVER);
        boolean isBinaries = isDriver && testParams.containsKey(BINARIES);

        // factoring
        if (!isDriver) {
            throw new NotFoundException("you must provide a valid 'driver'");
        }
        if (!isBinaries) {
            driverParams.setDriver(testParams.get(DRIVER).toString());
        }
        if (isBinaries) {
            driverParams.setDriver(testParams.get(DRIVER).toString()).setBinaries(testParams.get(BINARIES).toString());
        }

        // http setup
        if (testParams.get(DRIVER).toString().equals("HTTP")) {
            httpClient = new OkHttpClient();
            return;
        }

        // web-driver setup
        driver = new WebDriverFactory(driverParams).get();
    }

    // cleanup
    protected void onCleanup() {

    }

    private void cleanup() {
        if (driver != null) {
            driver.quit();
        }
    }
}