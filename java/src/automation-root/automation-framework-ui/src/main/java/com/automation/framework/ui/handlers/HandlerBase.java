package com.automation.framework.ui.handlers;

import com.automation.extensions.components.WebDriverExtensions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class HandlerBase {
    private final WebDriver driver;
    private final WebDriverExtensions extendedDriver;
    private final WebElement element;

    protected HandlerBase(WebDriver driver) {
        this(driver, null);
    }

    protected HandlerBase(WebDriver driver, WebElement element){
        this.driver = driver;
        this.extendedDriver = new WebDriverExtensions(driver);
        this.element = element;
    }

    public WebDriver getDriver(){
        return driver;
    }

    public WebDriverExtensions getExtendedDriver(){
        return extendedDriver;
    }

    public WebElement getElement(){
        return element;
    }
}
