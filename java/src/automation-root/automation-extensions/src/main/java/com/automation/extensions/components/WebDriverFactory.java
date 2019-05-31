package com.automation.extensions.components;

import com.automation.extensions.contracts.DriverParams;
import com.google.gson.Gson;

public class WebDriverFactory {
    private DriverParams driverParams;

    public WebDriverFactory(String driverParamsJson){
        this(loadParams(driverParamsJson));
    }

    public WebDriverFactory (DriverParams driverParams){
        this.driverParams = driverParams;
    }

    // load json into driver-params object
    private static DriverParams loadParams(String driverParamsJson){
        if(driverParamsJson == null || driverParamsJson.isEmpty()){
            return new DriverParams().setDriver("Chrome").setSource("Local").setBinaries(".");
        }
        return new Gson().fromJson(driverParamsJson, DriverParams.class);
    }
}
