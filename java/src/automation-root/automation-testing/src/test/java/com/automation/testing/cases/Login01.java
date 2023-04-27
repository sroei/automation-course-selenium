package com.automation.testing.cases;

import com.automation.api.pages.Login;
import com.automation.core.testing.TestCase;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Login01 extends TestCase {
    @Override
    public boolean automationTest(Map<String, Object> testParams) throws
            ClassNotFoundException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException,
            InvocationTargetException {

        // set test parameters
        String application = testParams.get("application").toString();
        String id = testParams.get("id").toString();
        String password = testParams.get("password").toString();
        String code = testParams.get("code").toString();
        String expectedMessage = testParams.get("expectedMessage").toString();
        String fluent = testParams.get("fluent").toString();
        String login = testParams.get("login").toString();

        // invoke
        String errorMessage = newFluentApi(fluent)
                .<Login>changeContext(login, application)
                .login(id, password, code)
                .getLoginMessage();

        // assert
        return errorMessage.equalsIgnoreCase(expectedMessage);
    }
}
