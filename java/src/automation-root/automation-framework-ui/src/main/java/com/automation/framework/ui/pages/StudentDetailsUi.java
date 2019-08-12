package com.automation.framework.ui.pages;

import com.automation.api.components.Enrollment;
import com.automation.api.pages.StudentDetails;
import com.automation.core.components.FluentUi;
import com.automation.core.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;

public class StudentDetailsUi extends FluentUi implements StudentDetails {
    public StudentDetailsUi(WebDriver driver) {
        super(driver);
    }

    public StudentDetailsUi(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    @Override
    public Enrollment[] enrollments() {
        return new Enrollment[0];
    }

    @Override
    public String firstName() {
        return getDriverExtensions().getElement(By.xpath("//dd[2]")).getText().trim();
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