package com.automation.api.components;

import java.time.LocalDateTime;

public interface Student {
    String firstName();

    String lastName();

    LocalDateTime enrollmentDate();

    Object edit();

    Object details();

    Object delete();
}
