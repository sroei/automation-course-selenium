package com.automation.framework.rest.pages;

import com.automation.api.components.Student;
import com.automation.api.pages.CreateStudent;
import com.automation.api.pages.Students;
import com.automation.core.components.FluentRest;
import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;
import com.automation.framework.rest.components.StudentRest;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentsRest extends FluentRest implements Students {
    private List<Student> studentList;

    public StudentsRest(OkHttpClient httpClient) throws IOException {
        this(httpClient, new TraceLogger());
    }

    private StudentsRest(OkHttpClient httpClient, Logger logger) throws IOException {
        this(httpClient, logger, "https://localhost");
    }

    public StudentsRest(OkHttpClient httpClient, Logger logger, String baseUrl) throws IOException {
        this(httpClient, logger, baseUrl, null);
    }

    private StudentsRest(OkHttpClient httpClient, Logger logger, String baseUrl, String name) throws IOException {
        super(httpClient, logger, baseUrl);
        studentList = build(name);
    }

    @Override
    public Students findByName(String name) throws IOException {
        return new StudentsRest(getHttpClient(), getLogger(), getBaseUrl(), name);
    }

    @Override
    public List<Student> students() {
        return studentList;
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

    // build pipeline
    private List<Student> build(String name) throws IOException {
        // initialize result
        ArrayList<Student> students = new ArrayList<>();

        // get all data-rows
        Request request = new Request.Builder().url(getBaseUrl() + "/api/Students").get().build();
        String responseBody = Objects.requireNonNull(getHttpClient().newCall(request).execute().body()).string();
        JsonArray dataRows = new JsonParser().parse(responseBody).getAsJsonArray();

        // iterate & build students
        for (int i = 0; i < dataRows.size(); i++) {
            Student student = new StudentRest(getHttpClient(), getLogger(), getBaseUrl(), dataRows.get(i));
            students.add(student);
        }

        if (name == null || name.equals("")) {
            return students;
        }
        return students
                .stream()
                .filter(i -> i.firstName().contains(name) || i.lastName().contains(name))
                .collect(Collectors.toList());
    }
}