package com.automation.framework.ui.pages;

import com.automation.api.components.Student;
import com.automation.api.pages.CreateStudent;
import com.automation.api.pages.Students;
import com.automation.core.components.FluentUi;
import com.automation.core.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class StudentsUi extends FluentUi implements Students {
    public StudentsUi(WebDriver driver) {
        super(driver);
    }

    public StudentsUi(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    @Override
    public Students findByName(String name) {
        WebElement element = getDriverExtensions().getEnabledElement(By.xpath("//input[@id='SearchString']"));
        element.sendKeys("Alexander");
        getDriverExtensions().submitForm(0);

        return this;
    }

    @Override
    public List<Student> students() {
        return new ArrayList<>();
    }

    @Override
    public CreateStudent create() {
        return null;
    }

    @Override
    public <T> T menu(String menuName) {
        return null;
    }

    @Override
    public Students next() {
        return null;
    }

    @Override
    public Students previous() {
        return null;
    }

    @Override
    public int pages() {
        return 0;
    }

    @Override
    public int page() {
        return 0;
    }
}