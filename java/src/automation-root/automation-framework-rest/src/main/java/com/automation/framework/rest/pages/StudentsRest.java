package com.automation.framework.rest.pages;

import com.automation.api.components.Student;
import com.automation.api.pages.CreateStudent;
import com.automation.api.pages.Students;
import com.automation.core.components.FluentRest;
import com.automation.core.logging.Logger;
import okhttp3.OkHttpClient;

import java.util.List;

public class StudentsRest extends FluentRest implements Students {
    public StudentsRest(OkHttpClient httpClient) {
        super(httpClient);
    }

    public StudentsRest(OkHttpClient httpClient, Logger logger) {
        super(httpClient, logger);
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
