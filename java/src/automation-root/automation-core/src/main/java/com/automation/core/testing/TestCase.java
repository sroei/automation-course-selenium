package com.automation.core.testing;

import com.automation.core.components.Fluent;
import com.automation.core.components.FluentBase;
import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;
import com.automation.extensions.components.WebDriverFactory;
import com.automation.extensions.contracts.DriverParams;
import okhttp3.OkHttpClient;
import org.openqa.selenium.WebDriver;
import sun.net.www.http.HttpClient;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    public abstract boolean automationTest(Map<String, Object> testParams)
            throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;

    public TestCase execute() throws MalformedURLException {
        for (int i = 0; i < attempts; i++) {
            setup();
            try {
                actual = automationTest(testParams);
                if (actual) {
                    break;
                }
                logger.debug(String.format("[%s] failed on attempt [%d]", getClass().getName(), i));
            } catch (NotImplementedException ex) {
                logger.debug(ex, ex.getMessage());
                break;
            } catch (NullPointerException ex) {
                logger.debug(ex, ex.toString());
                break;
            } catch (Exception ex) {
                logger.debug(ex, ex.getMessage());
            }
            finally {
                dispose();
            }
        }
        return this;
    }

    // properties - get actual
    public boolean getActual() {
        return actual;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public OkHttpClient getHttpClient(){
        return httpClient;
    }

    // configurations
    public TestCase withTestParams(Map<String, Object> testParams) {
        this.testParams = testParams;
        return this;
    }

    public TestCase withNumberOfAttempts(int numberOfAttempts) {
        this.attempts = numberOfAttempts;
        return this;
    }

    public TestCase withLogger(Logger logger) {
        this.logger = logger;
        return this;
    }

    // factory
    @SuppressWarnings("unchecked")
    public Fluent createFluentApi(String type)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // extracting class
        Class t = Class.forName(type);

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
    private void setup() throws MalformedURLException {
        // constants
        final String DRIVER = "driver";
        final String BINARIES = "driverBinaries";

        // default
        DriverParams driverParams = new DriverParams().setDriver("CHROME").setBinaries(".");

        // set driver if exists
        if (testParams != null && testParams.containsKey(DRIVER)) {
            driverParams.setDriver(testParams.get(DRIVER).toString()).setBinaries(testParams.get(BINARIES).toString());
        } else {
            assert testParams != null;
            testParams.put(DRIVER, "");
        }
        if (testParams != null && testParams.get(DRIVER).toString().equals("HTTP")) {
            httpClient = new OkHttpClient();
            return;
        }

        // generate driver
        driver = new WebDriverFactory(driverParams).get();
    }

    // cleanup
    private void dispose() {
        if (driver != null) {
            driver.quit();
        }
    }
}