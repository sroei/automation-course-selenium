package com.automation.framework.rest.pages;

import com.automation.api.pages.CreateStudent;
import com.automation.api.pages.Students;
import com.automation.core.components.FluentRest;
import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;
import okhttp3.OkHttpClient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class CreateStudentRest extends FluentRest implements CreateStudent {
    private Map<String, Object> student;

    public CreateStudentRest(OkHttpClient httpClient) {
        this(httpClient, new TraceLogger());
    }

    public CreateStudentRest(OkHttpClient httpClient, Logger logger) {
        this (httpClient, logger, "http://localhost");
    }

    public CreateStudentRest(OkHttpClient httpClient, Logger logger, String baseUrl) {
        super(httpClient, logger, baseUrl);
        student = new HashMap<>();
    }

    @Override
    public CreateStudent firstName(String fName) {
        student.put("firstMidName", fName);
        return this;
    }

    @Override
    public CreateStudent lastName(String lName) {
        student.put("lastName", lName);
        return this;
    }

    @Override
    public CreateStudent enrollmentDate(LocalDateTime eDate) {
        // parse date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String localDate = eDate.toLocalDate().format(formatter);
        student.put("enrollmentDate", localDate);
        return this;
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
}
