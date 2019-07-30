package com.automation.testing.cases;

import com.automation.api.pages.Students;
import com.automation.core.testing.TestCase;

import java.util.Map;

public class SearchStudents extends TestCase {
    @Override
    public boolean automationTest(Map<String, Object> testParams) {
        Students students = null;
        return !students.findByName("Alexander").students().isEmpty();
    }
}
