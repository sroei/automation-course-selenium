package com.automation.extensions.components;

import com.automation.extensions.contracts.DriverParams;
import com.google.gson.Gson;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {
    private DriverParams driverParams;

    public WebDriverFactory(String driverParamsJson){
        this(loadParams(driverParamsJson));
    }

    public WebDriverFactory (DriverParams driverParams){
        this.driverParams = driverParams;
    }

    // local web-drivers
    private WebDriver GetChrome() {
        // CHROME
        ChromeDriverService chromeDriverService = new ChromeDriverService
                .Builder()
                .usingDriverExecutable(new File(driverParams.getBinaries() + "\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();

        return new ChromeDriver(chromeDriverService);
    }

    private WebDriver GetFirefox() {
        // FIREFOX
        GeckoDriverService geckoDriverService = new GeckoDriverService
                .Builder()
                .usingDriverExecutable(new File(driverParams.getBinaries() + "\\geckodriver.exe"))
                .usingAnyFreePort()
                .build();

        return new FirefoxDriver(geckoDriverService);
    }

    private WebDriver GetInternetExplorer() {
        // INTERNET EXPLORER
        InternetExplorerDriverService ieDriverService = new InternetExplorerDriverService
                .Builder()
                .usingDriverExecutable(new File(driverParams.getBinaries() + "\\IEDriverServer.exe"))
                .usingAnyFreePort()
                .build();

        return new InternetExplorerDriver(ieDriverService);
    }

    private WebDriver GetEdge() {
        // EDGE
        EdgeDriverService edgeDriverService = new EdgeDriverService
                .Builder()
                .usingDriverExecutable(new File(driverParams.getBinaries() + "\\MicrosoftWebDriver.exe"))
                .usingAnyFreePort()
                .build();

        return new EdgeDriver(edgeDriverService);
    }

    // remote web-drivers
    private WebDriver GetRemoteChrome() throws MalformedURLException {
        return new RemoteWebDriver(new URL(driverParams.getBinaries()), new ChromeOptions());
    }

    private WebDriver GetRemoteFirefox() throws MalformedURLException {
        return new RemoteWebDriver(new URL(driverParams.getBinaries()), new FirefoxOptions());
    }

    private WebDriver GetRemoteInternetExplorer() throws MalformedURLException {
        return new RemoteWebDriver(new URL(driverParams.getBinaries()), new InternetExplorerOptions());
    }

    private WebDriver GetRemoteEdge() throws MalformedURLException {
        return new RemoteWebDriver(new URL(driverParams.getBinaries()), new EdgeOptions());
    }

    // load json into driver-params object
    private static DriverParams loadParams(String driverParamsJson){
        if(driverParamsJson == null || driverParamsJson.isEmpty()){
            return new DriverParams().setDriver("Chrome").setSource("Local").setBinaries(".");
        }
        return new Gson().fromJson(driverParamsJson, DriverParams.class);
    }
}