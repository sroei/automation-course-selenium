package com.automation.core.testing;

import com.automation.core.logging.Logger;

import java.util.Map;

public abstract class TestCase {

    // fields
    private Map<String, Object> testParams;
    private int attempts;
    private Logger logger;

    // components
    public abstract Boolean automationTest(Map<String, Object> testParams);

    public TestCase execute() {
        return this;
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