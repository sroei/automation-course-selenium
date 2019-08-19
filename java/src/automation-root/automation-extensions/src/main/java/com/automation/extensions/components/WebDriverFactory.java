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

@SuppressWarnings("SpellCheckingInspection")
public class WebDriverFactory {
    private DriverParams driverParams;

    public WebDriverFactory(String driverParamsJson){
        this(loadParams(driverParamsJson));
    }

    public WebDriverFactory (DriverParams driverParams){
        this.driverParams = driverParams;
    }

    /**
     * generate web-driver based on input params
     * @return web-driver instance
     * @throws MalformedURLException from inner factory
     */
    public WebDriver get() throws MalformedURLException {
        if(driverParams.getSource()==null || !driverParams.getSource().toUpperCase().equals("REMOTE")) {
            return getDriver();
        }
        return getRemoteDriver();
    }

    // local web-drivers
    private WebDriver getChrome() {
        // CHROME
        ChromeDriverService chromeDriverService = new ChromeDriverService
                .Builder()
                .usingDriverExecutable(new File(driverParams.getBinaries() + "\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();

        return new ChromeDriver(chromeDriverService);
    }

    private WebDriver getFirefox() {
        // FIREFOX
        GeckoDriverService geckoDriverService = new GeckoDriverService
                .Builder()
                .usingDriverExecutable(new File(driverParams.getBinaries() + "\\geckodriver.exe"))
                .usingAnyFreePort()
                .build();

        return new FirefoxDriver(geckoDriverService);
    }

    private WebDriver getInternetExplorer() {
        // INTERNET EXPLORER
        InternetExplorerDriverService ieDriverService = new InternetExplorerDriverService
                .Builder()
                .usingDriverExecutable(new File(driverParams.getBinaries() + "\\IEDriverServer.exe"))
                .usingAnyFreePort()
                .build();

        return new InternetExplorerDriver(ieDriverService);
    }

    private WebDriver getEdge() {
        // EDGE
        EdgeDriverService edgeDriverService = new EdgeDriverService
                .Builder()
                .usingDriverExecutable(new File(driverParams.getBinaries() + "\\MicrosoftWebDriver.exe"))
                .usingAnyFreePort()
                .build();

        return new EdgeDriver(edgeDriverService);
    }

    private WebDriver getDriver(){
        switch (driverParams.getDriver().toUpperCase()){
            case "EDGE": return getEdge();
            case "IE": return getInternetExplorer();
            case "FIREFOX": return getFirefox();
            case "CHROME":
            default: return getChrome();
        }
    }

    // remote web-drivers
    private WebDriver getRemoteChrome() throws MalformedURLException {
        return new RemoteWebDriver(new URL(driverParams.getBinaries()), new ChromeOptions());
    }

    private WebDriver getRemoteFirefox() throws MalformedURLException {
        return new RemoteWebDriver(new URL(driverParams.getBinaries()), new FirefoxOptions());
    }

    private WebDriver getRemoteInternetExplorer() throws MalformedURLException {
        return new RemoteWebDriver(new URL(driverParams.getBinaries()), new InternetExplorerOptions());
    }

    private WebDriver getRemoteEdge() throws MalformedURLException {
        return new RemoteWebDriver(new URL(driverParams.getBinaries()), new EdgeOptions());
    }

    private WebDriver getRemoteDriver() throws MalformedURLException {
        switch (driverParams.getDriver().toUpperCase()){
            case "EDGE": return getRemoteEdge();
            case "IE": return getRemoteInternetExplorer();
            case "FIREFOX": return getRemoteFirefox();
            case "CHROME":
            default: return getRemoteChrome();
        }
    }

    // load json into driver-params object
    private static DriverParams loadParams(String driverParamsJson){
        if(driverParamsJson == null || driverParamsJson.isEmpty()){
            return new DriverParams().setDriver("Chrome").setSource("Local").setBinaries(".");
        }
        return new Gson().fromJson(driverParamsJson, DriverParams.class);
    }
}