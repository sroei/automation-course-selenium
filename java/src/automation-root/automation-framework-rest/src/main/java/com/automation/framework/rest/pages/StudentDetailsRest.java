package com.automation.framework.rest.pages;

import com.automation.api.components.Enrollment;
import com.automation.api.components.Student;
import com.automation.api.pages.StudentDetails;
import com.automation.core.components.FluentRest;
import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;
import com.automation.framework.rest.components.StudentRest;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentDetailsRest extends FluentRest implements StudentDetails {
    private int studentId;
    private String fName;

    public StudentDetailsRest(OkHttpClient httpClient) throws IOException {
        this(httpClient, new TraceLogger());
    }

    private StudentDetailsRest(OkHttpClient httpClient, Logger logger) throws IOException {
        this(httpClient, logger, "http://localhost",0);
    }

    public StudentDetailsRest(OkHttpClient httpClient, Logger logger, String baseUrl, int studentId) throws IOException {
        super(httpClient, logger, baseUrl);
        this.studentId = studentId;
        build();
    }

    @Override
    public Enrollment[] enrollments() {
        return new Enrollment[0];
    }

    @Override
    public String firstName() {
        return fName;
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
    public StudentDetailsRest setStudentId(int studentId) throws IOException {
        this.studentId = studentId;
        return new StudentDetailsRest(getHttpClient(), getLogger(), getBaseUrl(), studentId);
    }

    // build pipeline
    private void build() throws IOException {
        // compose route
        String route = String.format("/api/Students/%d", studentId);

        // get all data-rows
        Request request = new Request.Builder().url(getBaseUrl() + "/api/Students").get().build();
        String responseBody = Objects.requireNonNull(getHttpClient().newCall(request).execute().body()).string();
        JsonObject dataRow = new JsonParser().parse(responseBody).getAsJsonObject();

        // set data
        fName = dataRow.get("firstMidName").getAsString();
    }
}