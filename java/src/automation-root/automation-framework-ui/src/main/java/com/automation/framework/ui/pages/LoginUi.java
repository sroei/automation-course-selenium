package com.automation.framework.ui.pages;

import com.automation.api.pages.Login;
import com.automation.core.components.FluentUi;
import com.automation.core.logging.Logger;
import com.automation.framework.ui.handlers.ButtonHandler;
import com.automation.framework.ui.handlers.ErrorLabelHandler;
import com.automation.framework.ui.handlers.TextBoxHandler;
import org.openqa.selenium.WebDriver;

public class LoginUi extends FluentUi implements Login {
    public LoginUi(WebDriver driver) {
        super(driver);
    }

    public LoginUi(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    @Override
    public Object forgotCode() {
        return null;
    }

    @Override
    public Object forgotPassword() {
        return null;
    }

    @Override
    public String getLoginMessage() {
        // setup
        ErrorLabelHandler errorLabelHandler = new ErrorLabelHandler(getDriver());

        // get
        return errorLabelHandler.getValue();
    }

    @Override
    public Login login(String id, String password, String code) {
        // setup
        TextBoxHandler textBoxHandler = new TextBoxHandler(getDriver());
        ButtonHandler buttonHandler = new ButtonHandler(getDriver());

        // invoke
        textBoxHandler.getElement("מספר זהות").sendKeys(id);
        textBoxHandler.getElement("סיסמה").sendKeys(password);
        textBoxHandler.getElement("קוד מזהה").sendKeys(code);
        buttonHandler.getElement("כניסה").click();

        // get
        return this;
    }
}
