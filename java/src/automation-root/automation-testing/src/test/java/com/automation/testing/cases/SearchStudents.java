package com.automation.testing.cases;

import com.automation.api.pages.Students;
import com.automation.core.components.FluentUi;
import com.automation.core.testing.TestCase;
import com.automation.framework.ui.pages.StudentsUi;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class SearchStudents extends TestCase {
    @Override
    public boolean automationTest(Map<String, Object> testParams)
            throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        // create driver for this test case
        String application = testParams.get("application").toString();
        String keyword = testParams.get("keyword").toString();

        return new FluentUi(getDriver())
                .<Students>changeContext(StudentsUi.class, application)
                .findByName(keyword)
                .students()
                .stream()
                .allMatch(i -> i.firstName().contains(keyword) || i.lastName().contains(keyword));
    }
}