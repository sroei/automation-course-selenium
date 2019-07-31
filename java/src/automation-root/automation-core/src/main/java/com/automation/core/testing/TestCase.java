package com.automation.core.testing;

import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public abstract class TestCase {

    // fields
    private Map<String, Object> testParams;
    private int attempts;
    private Logger logger;
    private boolean actual;

    protected TestCase(){
        testParams = new HashMap<String, Object>();
        attempts = 1;
        logger = new TraceLogger();
        actual = false;
    }

    // components
    public abstract boolean automationTest(Map<String, Object> testParams) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;

    public TestCase execute() {
        for (int i = 0; i < attempts; i++) {
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
        }
        return this;
    }

    // properties - get actual
    public boolean getActual(){
        return actual;
    }

    // configurations
    public TestCase withTestParams(Map<String, Object> testParams) {
        this.testParams = testParams;
        return this;
    }

    public TestCase withNumberOfAttempts(int numberOfAttempts){
        this.attempts = numberOfAttempts;
        return this;
    }

    public TestCase withLogger(Logger logger){
        this.logger = logger;
        return this;
    }
}