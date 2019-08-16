package com.automation.api.components;

import java.io.IOException;
import java.time.LocalDateTime;

public interface PersonalDetails {
    String firstName() throws IOException;

    String lastName();

    LocalDateTime enrollmentDate();
}
