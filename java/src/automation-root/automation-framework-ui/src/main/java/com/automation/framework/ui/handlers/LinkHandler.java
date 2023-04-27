package com.automation.framework.ui.handlers;

import com.automation.extensions.components.WebDriverExtensions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkHandler extends HandlerBase {
    private static final String LOCATOR_FORMAT = "//div[@role='link' and ./span[contains(.,'%s')]]";

    public LinkHandler(WebDriver driver) {
        super(driver);
    }

    public String getValue(String label) {
        // setup
        WebElement element = get(getExtendedDriver(), label);

        // get
        return element.getText();
    }

    public WebElement getElement(String label) {
        return get(getExtendedDriver(), label);
    }

    private static WebElement get(WebDriverExtensions extendedDriver, String label){
        // setup
        String xpath = String.format(LOCATOR_FORMAT, label);

        // get
        return extendedDriver.getElement(By.xpath(xpath));
    }
}
