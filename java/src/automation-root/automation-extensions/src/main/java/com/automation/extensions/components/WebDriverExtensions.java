package com.automation.extensions.components;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;


public class WebDriverExtensions {
    private WebDriver driver;
    private FluentWait<WebDriver> wait;

    public WebDriverExtensions(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver).ignoring(NoSuchElementException.class);
    }

    public WebDriver goToUrl(String url) {
        driver.navigate().to(url);
        driver.manage().window().maximize();
        return driver;
    }

    public WebElement getElement(By by) {
        return getElement(by, Duration.ofSeconds(15));
    }

    public WebElement getElement(By by, Duration timeout) {
        return wait.withTimeout(timeout).until(d -> d.findElement(by));
    }
}