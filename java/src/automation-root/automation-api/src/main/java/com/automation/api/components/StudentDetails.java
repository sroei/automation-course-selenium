package com.automation.api.components;

import java.time.LocalDateTime;

public interface StudentDetails {
    String firstName();

    String lastName();

    LocalDateTime enrollmentDate();
}
