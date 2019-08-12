package com.automation.api.pages;

import com.automation.api.components.Back;
import com.automation.api.components.Create;
import com.automation.api.components.PersonalDetails;

import java.time.LocalDateTime;

public interface CreateStudent extends PersonalDetails, Create<Students>, Back<Students> {
    CreateStudent firstName(String fName);

    CreateStudent lastName(String lName);

    CreateStudent enrollmentDate(LocalDateTime eDate);
}