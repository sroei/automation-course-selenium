package com.automation.framework.rest.components;

import com.automation.api.components.Student;
import com.automation.api.pages.StudentDetails;
import com.automation.core.components.FluentRest;
import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StudentRest extends FluentRest implements Student {
    private String fName;
    private String lName;
    private LocalDateTime eDate;
    private Gson gson;

    public StudentRest(OkHttpClient httpClient, JsonElement dataRow) {
        this(httpClient, new TraceLogger());
        gson = new Gson();
        build(dataRow);
    }

    private StudentRest(OkHttpClient httpClient, Logger logger) {
        super(httpClient, logger);
    }

    @Override
    public Object edit() {
        return null;
    }

    @Override
    public StudentDetails details() {
        return null;
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
    private void build(JsonElement dataRow) {
        JsonObject jsonObject = gson.fromJson(dataRow.toString(), JsonObject.class);
        fName = jsonObject.get("firstMidName").getAsString();
        lName = jsonObject.get("lastName").getAsString();
        eDate = LocalDateTime.parse(jsonObject.get("enrollmentDate").getAsString());
    }
}