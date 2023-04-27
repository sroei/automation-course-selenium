package com.automation.framework.ui.handlers;

import com.automation.extensions.components.WebDriverExtensions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxHandler extends HandlerBase {
    // members: static
    private static final String LOCATOR_FORMAT = "//div[./span[contains(.,'%s')]]/input";

    public TextBoxHandler(WebDriver driver) {
        super(driver);
    }

    public String getValue(String label) {
        // setup
        WebElement element = get(getExtendedDriver(), label);

        // not found
        if (!element.getTagName().equalsIgnoreCase("INPUT")){
            return "";
        }

        // get
        return element.getAttribute("value");
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
