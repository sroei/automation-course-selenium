package com.automation.framework.rest.pages;

import com.automation.api.components.Enrollment;
import com.automation.api.pages.StudentDetails;
import com.automation.core.components.FluentRest;
import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;
import okhttp3.OkHttpClient;

import java.time.LocalDateTime;

public class StudentDetailsRest extends FluentRest implements StudentDetails {
    private int studentId;

    public StudentDetailsRest(OkHttpClient httpClient) {
        this(httpClient, new TraceLogger());
    }

    private StudentDetailsRest(OkHttpClient httpClient, Logger logger) {
        this(httpClient, logger, "http://localhost");
    }

    private StudentDetailsRest(OkHttpClient httpClient, Logger logger, String baseUrl) {
        super(httpClient, logger, baseUrl);
    }

    @Override
    public Enrollment[] enrollments() {
        return new Enrollment[0];
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

    // non interface fields
    public StudentDetailsRest setStudentId(int studentId) {
        this.studentId = studentId;
        return this;
    }
}