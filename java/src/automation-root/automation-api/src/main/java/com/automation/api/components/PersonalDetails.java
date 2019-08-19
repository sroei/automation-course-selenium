package com.automation.api.components;

import java.time.LocalDateTime;

@SuppressWarnings("unused")
public interface PersonalDetails {
    String firstName();

    String lastName();

    LocalDateTime enrollmentDate();
}
