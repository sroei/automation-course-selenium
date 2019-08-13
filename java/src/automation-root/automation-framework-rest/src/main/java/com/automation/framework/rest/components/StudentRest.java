package com.automation.framework.rest.components;

import com.automation.api.components.Student;
import com.automation.api.pages.StudentDetails;
import com.automation.core.components.FluentRest;
import com.automation.core.logging.Logger;
import okhttp3.OkHttpClient;

import java.time.LocalDateTime;

public class StudentRest extends FluentRest implements Student {
    public StudentRest(OkHttpClient httpClient) {
        super(httpClient);
    }

    public StudentRest(OkHttpClient httpClient, Logger logger) {
        super(httpClient, logger);
    }

    @Override
    public Object edit() {
        return null;
    }

    @Override
    public StudentDetails details() {
        return null;
    }

    @Override
    public Object delete() {
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