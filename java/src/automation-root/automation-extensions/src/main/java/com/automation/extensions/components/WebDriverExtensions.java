package com.automation.extensions.components;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;


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

    public Select asSelect(WebElement element) {
        return new Select(element);
    }

    public List<WebElement> getElements(By by) {
        return getElements(by, Duration.ofSeconds(15));
    }

    public List<WebElement> getElements(By by, Duration timeout) {
        return wait.withTimeout(timeout).until(d -> d.findElements(by));
    }
}