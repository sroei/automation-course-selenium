package com.automation.testing.containers;

import com.automation.testing.cases.Login01;
import com.automation.testing.cases.SearchStudents;
import com.automation.testing.tools.Utilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Map;

public class LoginTests {
    @Test(dataProvider = "loginProvider")
    public void loginNegativeTest(Map<String, Object> testParams) throws MalformedURLException {
        // execute & get actual result
        boolean actual = new Login01().setTestParams(testParams).invoke().getActual();

        //  assert actual
        Assert.assertTrue(actual);
    }

    @DataProvider(name = "loginProvider")
    public Object[][] loginProvider(){
        // data to pass as test parameters
        String json = "[" +
                "{" +
                "   'driver':'EDGE'," +
                "   'driverBinaries':'E:\\\\AutomationEnvironment\\\\WebDrivers'," +
                "   'application':'https://start.telebank.co.il/login/#/LOGIN_PAGE'," +
                "   'fluent':'com.automation.core.components.FluentUi'," +
                "   'login':'com.automation.framework.ui.pages.LoginUi'," +
                "   'id':'65921355'," +
                "   'password':'Dora4646'," +
                "   'code':'9g9dn8'," +
                "   'expectedMessage':'Foo Bar'" +
                "}]";

        // return data-provider
        return Utilities.dataProviderFactory(json);
    }
}
