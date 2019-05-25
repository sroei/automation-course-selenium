/*
 * DOWNLOAD LINKS
 * ie:     https://www.seleniumhq.org/download/
 * gecko:  https://github.com/mozilla/geckodriver/releases
 * chrome: http://chromedriver.chromium.org/downloads
 */
package com.automation.testing.samples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.testng.annotations.Test;

import java.io.File;

public class SeleniumSamples {

    @Test
    public void WebDriverSamples() throws InterruptedException {
        // CHROME
        ChromeDriverService chromeDriverService = new ChromeDriverService
                .Builder()
                .usingDriverExecutable(new File("D:\\garbage\\web-drivers\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();

        WebDriver driver = new ChromeDriver(chromeDriverService);
        Thread.sleep(1000);
        driver.quit();

        // FIREFOX
        GeckoDriverService geckoDriverService = new GeckoDriverService
                .Builder()
                .usingDriverExecutable(new File("D:\\garbage\\web-drivers\\geckodriver.exe"))
                .usingAnyFreePort()
                .build();

        driver = new FirefoxDriver(geckoDriverService);
        Thread.sleep(1000);
        driver.quit();

        // INTERNET EXPLORER
        InternetExplorerDriverService ieDriverService = new InternetExplorerDriverService
                .Builder()
                .usingDriverExecutable(new File("D:\\garbage\\web-drivers\\IEDriverServer.exe"))
                .usingAnyFreePort()
                .build();

        driver = new InternetExplorerDriver(ieDriverService);
        Thread.sleep(1000);
        driver.quit();
    }
}