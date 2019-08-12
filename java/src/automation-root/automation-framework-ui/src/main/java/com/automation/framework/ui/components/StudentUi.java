package com.automation.framework.ui.components;

import com.automation.api.components.Student;
import com.automation.api.pages.StudentDetails;
import com.automation.core.components.FluentUi;
import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;
import com.automation.framework.ui.pages.StudentDetailsUi;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StudentUi extends FluentUi implements Student {
    private WebElement dataRow;
    private String fName;
    private String lName;
    private LocalDateTime eDate;

    public StudentUi(WebDriver driver, WebElement dataRow) {
        this(driver, new TraceLogger());
        this.dataRow = dataRow;
        build(dataRow);
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
    public StudentDetails details() {
        dataRow.findElement(By.xpath(".//a[contains(@href,'/Student/Details')]")).click();
        return new StudentDetailsUi(getDriver());
    }

    @Override
    public Object delete() {
        return null;
    }

    // data
    @Override
    public String firstName() {
        return fName;
    }

    @Override
    public String lastName() {
        return lName;
    }

    @Override
    public LocalDateTime enrollmentDate() {
        return eDate;
    }

    // processing
    private void build(WebElement dataRow){
        lName = dataRow.findElement(By.xpath("./td[1]")).getText().trim();
        fName = dataRow.findElement(By.xpath("./td[2]")).getText().trim();

        // parse date
        String dateString = dataRow.findElement(By.xpath("./td[3]")).getText().trim() + " 00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        eDate = LocalDateTime.parse(dateString, formatter);
    }
}