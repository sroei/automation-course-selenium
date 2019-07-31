package com.automation.testing.containers;

import com.automation.testing.cases.SearchStudents;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StudentTests {
    @Test
    public void searchStudentUiTest() {
        boolean actual = new SearchStudents().execute().getActual();
        Assert.assertTrue(actual);
    }
}