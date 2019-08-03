package com.automation.testing.cases;

import com.automation.core.components.FluentUi;
import com.automation.core.testing.TestCase;
import com.automation.framework.ui.pages.StudentsUi;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.Map;

public class CreateStudent extends TestCase {
    @Override
    public boolean automationTest(Map<String, Object> testParams)
            throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        // create driver for this test case
        String application = testParams.get("application").toString();
        String keyword = testParams.get("keyword").toString();

        return new FluentUi(getDriver())
                .<StudentsUi>changeContext(application)
                .create()
                .firstName("java")
                .lastName("student")
                .enrollmentDate(LocalDateTime.now())
                .create()
                .findByName("java")
                .students()
                .size() > 0;
    }
}