package com.automation.testing.cases;

import com.automation.core.components.FluentUi;
import com.automation.core.testing.TestCase;
import com.automation.extensions.components.WebDriverFactory;
import com.automation.extensions.contracts.DriverParams;
import com.automation.framework.ui.pages.StudentsUi;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.Map;

public class SearchStudents extends TestCase {
    @Override
    public boolean automationTest(Map<String, Object> testParams)
            throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        // create driver for this test case
        String driverParam = testParams.get("driver").toString();
        String application = testParams.get("application").toString();
        String keyword = testParams.get("keyword").toString();

        WebDriver driver = new WebDriverFactory(new DriverParams().setBinaries(".").setDriver(driverParam)).get();

        return new FluentUi(driver)
                .<StudentsUi>changeContext(application)
                .findByName(keyword)
                .students()
                .stream()
                .allMatch(i -> i.firstName().contains(keyword) || i.lastName().contains(keyword));
    }
}