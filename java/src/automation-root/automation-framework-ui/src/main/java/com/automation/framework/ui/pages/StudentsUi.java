package com.automation.framework.ui.pages;

import com.automation.api.components.Student;
import com.automation.api.pages.CreateStudent;
import com.automation.api.pages.Students;
import com.automation.core.components.FluentUi;
import com.automation.core.logging.Logger;
import com.automation.framework.ui.components.StudentUi;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unused", "WeakerAccess", "SpellCheckingInspection"})
public class StudentsUi extends FluentUi implements Students {
    public StudentsUi(WebDriver driver) {
        super(driver);
    }

    public StudentsUi(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    @Override
    public Students findByName(String name) {
        WebElement element = getExtendedDriver().getEnabledElement(By.xpath("//input[@id='SearchString']"));
        element.sendKeys(name);
        getExtendedDriver().submitForm(0);

        return this;
    }

    @Override
    public List<Student> students() {
        // initialize result
        ArrayList<Student> students = new ArrayList<>();

        // get all data-rows
        List<WebElement> dataRows = getExtendedDriver().getElements(By.xpath("//tbody/tr"));

        // iterate & build students
        for (WebElement dataRow : dataRows) {
            Student student = new StudentUi(getDriver(), dataRow);
            students.add(student);
        }
        return students;
    }

    @Override
    public CreateStudent create() {
        getExtendedDriver().getEnabledElement(By.xpath("//a[contains(@href,'/Student/Create')]")).click();
        return new CreateStudentUi(getDriver());
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