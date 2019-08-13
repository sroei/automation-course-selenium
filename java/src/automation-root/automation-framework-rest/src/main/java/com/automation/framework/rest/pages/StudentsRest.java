package com.automation.framework.rest.pages;

import com.automation.api.components.Student;
import com.automation.api.pages.CreateStudent;
import com.automation.api.pages.Students;
import com.automation.core.components.FluentRest;
import com.automation.core.logging.Logger;
import com.automation.core.logging.TraceLogger;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.List;

public class StudentsRest extends FluentRest implements Students {
    public StudentsRest(OkHttpClient httpClient) throws IOException {
        this(httpClient, new TraceLogger());
    }

    public StudentsRest(OkHttpClient httpClient, Logger logger) throws IOException {
        super(httpClient, logger);

        Request request = new Request.Builder().url("https://gravitymvctestapplication.azurewebsites.net/api/Students").get().build();
        String responseBody = httpClient.newCall(request).execute().body().string();
        JsonArray studentsArray = new JsonParser().parse(responseBody).getAsJsonArray();
    }

    @Override
    public Students findByName(String name) {
        return null;
    }

    @Override
    public List<Student> students() {
        return null;
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
