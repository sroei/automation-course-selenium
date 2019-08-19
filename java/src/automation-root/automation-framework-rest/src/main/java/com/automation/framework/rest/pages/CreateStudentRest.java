package com.automation.framework.rest.pages;

import com.automation.api.pages.CreateStudent;
import com.automation.api.pages.Students;
import com.automation.core.components.FluentRest;
import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;
import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;
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
        this(httpClient, logger, "http://localhost");
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
    public Students backToList() throws IOException {
        return new StudentsRest(getHttpClient(), getLogger(), getBaseUrl());
    }

    @Override
    public Students create() throws IOException {
        // request body
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), new Gson().toJson(student));
        Request request = new Request.Builder().post(requestBody).url(getBaseUrl() + "/api/Students").build();

        // execute request
        getHttpClient().newCall(request).execute();

        // return new students call
        return new StudentsRest(getHttpClient(), getLogger(), getBaseUrl());
    }

    @Override
    public String firstName() {
        final String KEY = "firstMidName";
        return student.containsKey(KEY) ? student.get(KEY).toString() : "";
    }

    @Override
    public String lastName() {
        final String KEY = "lastName";
        return student.containsKey(KEY) ? student.get(KEY).toString() : "";
    }

    @Override
    public LocalDateTime enrollmentDate() {
        final String KEY = "enrollmentDate";
        return student.containsKey(KEY)
                ? LocalDateTime.parse(student.get(KEY).toString())
                : LocalDateTime.parse("1980-01-01 00:00:00");
    }
}