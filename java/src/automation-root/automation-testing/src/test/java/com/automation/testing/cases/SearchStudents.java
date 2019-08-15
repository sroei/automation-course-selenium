package com.automation.testing.cases;

import com.automation.api.pages.Students;
import com.automation.core.testing.TestCase;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class SearchStudents extends TestCase {
    @Override
    public boolean automationTest(Map<String, Object> testParams)
            throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {

        // create driver for this test case
        String application = testParams.get("application").toString();
        String keyword = testParams.get("keyword").toString();
        String fluent = testParams.get("fluent").toString();
        String students = testParams.get("students").toString();

        return createFluentApi(fluent)
                .<Students>changeContext(students, application)
                .findByName(keyword)
                .students()
                .stream()
                .allMatch(i -> i.firstName().contains(keyword) || i.lastName().contains(keyword));
    }
}