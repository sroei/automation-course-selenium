package com.automation.api.components;

import com.automation.api.pages.StudentDetails;

import java.time.LocalDateTime;

public interface Student extends PersonalDetails, Edit<Object>, Details<StudentDetails>, Delete<Object> {
}