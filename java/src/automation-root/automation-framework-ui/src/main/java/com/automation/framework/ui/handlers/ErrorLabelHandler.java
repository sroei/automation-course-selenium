package com.automation.framework.ui.handlers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErrorLabelHandler extends HandlerBase {
    // members: static
    private static final String LOCATOR_FORMAT = "//div[@role='alert' and contains(@class,'-msg')]";

    public ErrorLabelHandler(WebDriver driver) {
        super(driver);
    }

    public String getValue() {
        // setup
        WebElement element = getExtendedDriver().getElement(By.xpath(LOCATOR_FORMAT));

        // get
        return element.getText();
    }
}
