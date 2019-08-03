package com.automation.api.pages;

import com.automation.api.components.Back;
import com.automation.api.components.Create;
import com.automation.api.components.StudentDetails;

import java.time.LocalDateTime;

public interface CreateStudent extends StudentDetails, Create<Students>, Back<Students> {
    CreateStudent firstName(String fName);

    CreateStudent lastName(String lName);

    CreateStudent enrollmentDate(LocalDateTime eDate);
}