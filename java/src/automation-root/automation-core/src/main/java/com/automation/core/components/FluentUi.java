package com.automation.core.components;

import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;
import org.openqa.selenium.WebDriver;

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

    public <T> T changeContext() {
        return null;
    }

    public <T> T changeContext(String application) {
        return null;
    }
}