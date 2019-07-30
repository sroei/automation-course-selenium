package com.automation.api.pages;

import com.automation.api.components.Back;
import com.automation.api.components.Create;
import com.automation.api.components.StudentDetails;

public interface CreateStudent extends StudentDetails, Create<Students>, Back<Students> {
}