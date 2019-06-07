package com.automation.extensions.components;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class WebDriverExtensions {
    private WebDriver driver;

    public WebDriverExtensions(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver goToUrl(String url) {
        driver.navigate().to(url);
        driver.manage().window().maximize();
        return driver;
    }
}
