package com.automation.framework.ui.handlers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonHandler extends HandlerBase{
    private static final String LOCATOR_FORMAT = "//button[./span[.='%s']]";

    public ButtonHandler(WebDriver driver) {
        super(driver);
    }

    public WebElement getElement(String label) {
        // setup
        String xpath = String.format(LOCATOR_FORMAT, label);

        // get
        return getExtendedDriver().getElement(By.xpath(xpath));
    }
}
