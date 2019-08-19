package com.automation.framework.rest.pages;

import com.automation.api.pages.CreateStudent;
import com.automation.api.pages.Students;
import com.automation.core.components.FluentRest;
import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;
import okhttp3.OkHttpClient;

import java.time.LocalDateTime;

public class CreateStudentRest extends FluentRest implements CreateStudent {
    public CreateStudentRest(OkHttpClient httpClient) {
        this(httpClient, new TraceLogger());
    }

    public CreateStudentRest(OkHttpClient httpClient, Logger logger) {
        this (httpClient, logger, "http://localhost");
    }

    public CreateStudentRest(OkHttpClient httpClient, Logger logger, String baseUrl) {
        super(httpClient, logger, baseUrl);
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
