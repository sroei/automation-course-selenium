package com.automation.framework.rest.components;

import com.automation.api.components.Student;
import com.automation.api.pages.StudentDetails;
import com.automation.core.components.FluentRest;
import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;
import com.automation.framework.rest.pages.StudentDetailsRest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StudentRest extends FluentRest implements Student {
    private String fName;
    private String lName;
    private LocalDateTime eDate;
    private int studentId;
    private Gson gson;

    public StudentRest(OkHttpClient httpClient, JsonElement dataRow) {
        this(httpClient, new TraceLogger(), dataRow);
    }

    private StudentRest(OkHttpClient httpClient, Logger logger, JsonElement dataRow) {
        this(httpClient, logger, "http://localhost", dataRow);
    }

    public StudentRest(OkHttpClient httpClient, Logger logger, String baseUrl, JsonElement dataRow) {
        super(httpClient, logger, baseUrl);
        gson = new Gson();
        build(dataRow);
    }

    @Override
    public Object edit() {
        return null;
    }

    @Override
    public StudentDetails details() throws IOException {
        return new StudentDetailsRest(getHttpClient(), getLogger(), getBaseUrl(), studentId);
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
        studentId = jsonObject.get("id").getAsInt();
    }
}