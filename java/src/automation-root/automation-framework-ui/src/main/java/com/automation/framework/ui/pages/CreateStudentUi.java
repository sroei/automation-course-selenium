package com.automation.framework.ui.pages;

import com.automation.api.pages.CreateStudent;
import com.automation.api.pages.Students;
import com.automation.core.components.FluentUi;
import com.automation.core.logging.Logger;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;

public class CreateStudentUi extends FluentUi implements CreateStudent {
    public CreateStudentUi(WebDriver driver) {
        super(driver);
    }

    public CreateStudentUi(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    @Override
    public Students backToList() {
        return null;
    }

    @Override
    public Students create() {
        return null;
    }

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

    @Override
    public CreateStudent firstName(String fName) {
        return null;
    }

    @Override
    public CreateStudent lastName(String lName) {
        return null;
    }

    @Override
    public CreateStudent enrollmentDate(LocalDateTime eDate) {
        return null;
    }
}