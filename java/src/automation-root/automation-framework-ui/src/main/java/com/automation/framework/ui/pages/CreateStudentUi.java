package com.automation.framework.ui.pages;

import com.automation.api.pages.CreateStudent;
import com.automation.api.pages.Students;
import com.automation.core.components.FluentUi;
import com.automation.core.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings({"unused", "WeakerAccess"})
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
        getDriverExtensions().getEnabledElement(By.xpath("//input[@type='submit']")).click();
        return new StudentsUi(getDriver());
    }

    @Override
    public String firstName() {
        return getDriverExtensions().getEnabledElement(By.xpath("//input[@id='FirstMidName']")).getAttribute("value");
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
        getDriverExtensions().getEnabledElement(By.xpath("//input[@id='FirstMidName']")).sendKeys(fName);
        return this;
    }

    @Override
    public CreateStudent lastName(String lName) {
        getDriverExtensions().getEnabledElement(By.xpath("//input[@id='LastName']")).sendKeys(lName);
        return this;
    }

    @Override
    public CreateStudent enrollmentDate(LocalDateTime eDate) {
        // parse date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String localDate = eDate.toLocalDate().format(formatter);

        // JS
        String script = String.format("document.getElementById('EnrollmentDate').setAttribute('value','%s');", localDate);
        ((JavascriptExecutor)getDriver()).executeScript(script);
        return this;
    }
}