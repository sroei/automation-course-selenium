package com.automation.testing.containers;

import com.automation.api.components.Student;
import com.automation.api.pages.Students;
import com.automation.core.components.FluentRest;
import com.automation.framework.rest.pages.StudentsRest;
import com.automation.framework.ui.pages.StudentsUi;
import com.automation.testing.cases.CreateStudent;
import com.automation.testing.cases.SearchStudents;
import com.automation.testing.cases.StudentDetails;
import com.automation.testing.tools.Utilities;
import okhttp3.OkHttpClient;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.List;
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

    @Test(dataProvider = "details-data-provider")
    public void studentDetailsTest(Map<String, Object> testParams) throws MalformedURLException {
        // execute & get actual result
        boolean actual = new StudentDetails().withTestParams(testParams).execute().getActual();

        //  assert actual
        Assert.assertTrue(actual);
    }

    @Test
    public void tempTest() throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        List<Student> students = new FluentRest(new OkHttpClient()).<Students>changeContext(StudentsRest.class, "https://gravitymvctestapplication.azurewebsites.net").students();
        String f = students.get(0).firstName();
    }

    @DataProvider(name = "search-data-provider")
    public Object[][] searchStudentProvider() {
        return searchProvider();
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

    @DataProvider(name = "details-data-provider")
    public Object[][] studentDetailsProvider() {
        return searchProvider();
    }

    private Object[][] searchProvider(){
        // data to pass as test parameters
        String json = "[" +
                "{" +
                "'driver':'CHROME'," +
                "'driverBinaries':'D:\\\\automation-env\\\\web-drivers'," +
                "'application':'https://gravitymvctestapplication.azurewebsites.net/Student'," +
                "'keyword':'Alexander'," +
                "'fluent':'com.automation.core.components.FluentUi'," +
                "'students':'com.automation.framework.ui.pages.StudentsUi'" +
                "}," +
                "{" +
                "'driver':'HTTP'," +
                "'application':'https://gravitymvctestapplication.azurewebsites.net'," +
                "'keyword':'Alexander'," +
                "'fluent':'com.automation.core.components.FluentRest'," +
                "'students':'com.automation.framework.rest.pages.StudentsRest'" +
                "}" +
                "]";

        // return data-provider
        return Utilities.dataProviderFactory(json);
    }
}