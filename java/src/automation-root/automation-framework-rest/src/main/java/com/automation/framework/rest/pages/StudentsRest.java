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

public class StudentsRest extends FluentRest implements Students {
    public StudentsRest(OkHttpClient httpClient) {
        this(httpClient, new TraceLogger());
    }

    private StudentsRest(OkHttpClient httpClient, Logger logger) {
        super(httpClient, logger);
    }

    @Override
    public Students findByName(String name) {
        return null;
    }

    @Override
    public List<Student> students() throws IOException {
        // initialize result
        ArrayList<Student> students = new ArrayList<>();

        // get all data-rows
        Request request = new Request.Builder().url("https://gravitymvctestapplication.azurewebsites.net/api/Students").get().build();
        String responseBody = Objects.requireNonNull(getHttpClient().newCall(request).execute().body()).string();
        JsonArray dataRows = new JsonParser().parse(responseBody).getAsJsonArray();

        // iterate & build students
        for (int i = 0; i < dataRows.size(); i++) {
            Student student = new StudentRest(getHttpClient(), dataRows.get(i));
            students.add(student);
        }
        return students;
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
}
