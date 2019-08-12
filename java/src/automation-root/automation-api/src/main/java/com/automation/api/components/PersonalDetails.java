package com.automation.api.components;

import java.time.LocalDateTime;

public interface PersonalDetails {
    String firstName();

    String lastName();

    LocalDateTime enrollmentDate();
}
