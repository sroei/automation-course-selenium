package com.automation.testing.cases;

import com.automation.api.components.Student;
import com.automation.api.pages.Students;
import com.automation.core.testing.TestCase;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class StudentDetails extends TestCase {
    @Override
    public boolean automationTest(Map<String, Object> testParams)
            throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        // create driver for this test case
        String application = testParams.get("application").toString();
        String keyword = testParams.get("keyword").toString();
        String fluent = testParams.get("fluent").toString();
        String students = testParams.get("students").toString();

        Student student = newFluentApi(fluent)
                .<Students>changeContext(students, application)
                .findByName(keyword)
                .students()
                .stream()
                .findFirst()
                .orElse(null);

        // extract expected result
        assert student != null;
        String expected = student.firstName();

        // assert
        return student.details().firstName().equals(expected);
    }
}