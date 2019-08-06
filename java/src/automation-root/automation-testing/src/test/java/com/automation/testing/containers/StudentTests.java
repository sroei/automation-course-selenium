package com.automation.testing.containers;

import com.automation.testing.cases.CreateStudent;
import com.automation.testing.cases.SearchStudents;
import com.automation.testing.tools.Utilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Map;

public class StudentTests {
    @Test(dataProvider = "search-data-provider")
    public void searchStudentUiTest(Map<String, Object> testParams) throws MalformedURLException {
        // execute & get actual result
        boolean actual = new SearchStudents().withTestParams(testParams).execute().getActual();

        //  assert actual
        Assert.assertTrue(actual);
    }

    @Test(dataProvider = "create-data-provider")
    public void createStudentUiTest(Map<String, Object> testParams) throws MalformedURLException {
        // execute & get actual result
        boolean actual = new CreateStudent().withTestParams(testParams).execute().getActual();

        //  assert actual
        Assert.assertTrue(actual);
    }

    @DataProvider(name = "search-data-provider")
    public Object[][] searchStudentProvider() {
        // data to pass as test parameters
        String json = "{" +
                "'driver':'CHROME'," +
                "'driverBinaries':'D:\\\\automation-env\\\\web-drivers'," +
                "'application':'https://gravitymvctestapplication.azurewebsites.net/Student'," +
                "'keyword':'Alexander'" +
                "}";

        // return data-provider
        return Utilities.dataProviderFactory(json);
    }

    @DataProvider(name = "create-data-provider")
    public Object[][] createStudentProvider() {
        // data to pass as test parameters
        String json = "{" +
                "'driver':'CHROME'," +
                "'driverBinaries':'D:\\\\automation-env\\\\web-drivers'," +
                "'application':'https://gravitymvctestapplication.azurewebsites.net/Student'," +
                "'firstName':'java'," +
                "'lastName':'student'" +
                "}";

        // return data-provider
        return Utilities.dataProviderFactory(json);
    }
}