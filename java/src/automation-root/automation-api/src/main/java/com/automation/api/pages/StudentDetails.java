package com.automation.api.pages;

import com.automation.api.components.Enrollment;
import com.automation.api.components.PersonalDetails;

@SuppressWarnings("unused")
public interface StudentDetails extends PersonalDetails {
    Enrollment[] enrollments();
}
