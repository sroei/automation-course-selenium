package com.automation.framework.ui.components;

import com.automation.api.components.Student;
import com.automation.core.components.FluentUi;
import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;

public class StudentUi extends FluentUi implements Student {
    private WebElement dataRow;

    public StudentUi(WebDriver driver, WebElement dataRow) {
        this(driver, new TraceLogger());
        this.dataRow = dataRow;
    }

    private StudentUi(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    // actions
    @Override
    public Object edit() {
        return null;
    }

    @Override
    public Object details() {
        return null;
    }

    @Override
    public Object delete() {
        return null;
    }

    // data
    @Override
    public String firstName() {
        return null;
    }

    @Override
    public String lastName() {
        return null;
    }

    @Override
    public LocalDateTime enrollmentDate() {
        return null;
    }
}