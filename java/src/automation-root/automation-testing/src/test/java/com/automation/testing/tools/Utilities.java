package com.automation.testing.tools;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Utilities {
    public static Object[][] dataProviderFactory(String json) {
        // create type token
        Type typeToken = new TypeToken<HashMap<String, Object>>() {
        }.getType();

        // create test parameter map
        Map<String, Object> testParams = new Gson().fromJson(json, typeToken);

        // return data-provider
        return new Object[][]{{testParams}};
    }
}