package com.automation.core.testing;

import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;

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
    public abstract boolean automationTest(Map<String, Object> testParams);

    public TestCase execute() {
        actual = automationTest(testParams);
        return this;
    }

    // properties
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