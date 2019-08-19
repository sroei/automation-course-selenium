package com.automation.testing.cases;

import com.automation.api.pages.Students;
import com.automation.core.testing.TestCase;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.Map;

public class CreateStudent extends TestCase {
    @Override
    public boolean automationTest(Map<String, Object> testParams)
            throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {

        // create driver for this test case
        String application = testParams.get("application").toString();
        String firstName = testParams.get("firstName").toString();
        String lastName = testParams.get("lastName").toString();
        String fluent = testParams.get("fluent").toString();
        String students = testParams.get("students").toString();

        return createFluentApi(fluent)
                .<Students>changeContext(students, application)
                .create()
                .firstName(firstName)
                .lastName(lastName)
                .enrollmentDate(LocalDateTime.now())
                .create()
                .findByName(firstName)
                .students()
                .size() > 0;
    }
}