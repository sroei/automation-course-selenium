/*
 * DOWNLOAD LINKS
 * ie:        https://www.seleniumhq.org/download/
 * gecko:     https://github.com/mozilla/geckodriver/releases
 * chrome:    http://chromedriver.chromium.org/downloads
 * test-site: https://gravitymvctestapplication.azurewebsites.net/
 */
package com.automation.testing.samples;

import com.automation.extensions.components.WebDriverExtensions;
import com.automation.extensions.components.WebDriverFactory;
import com.automation.extensions.contracts.DriverParams;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class SeleniumSamples {

    @Test
    public void webDriverSamples() throws InterruptedException {
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

    @Test
    public void webElementSamples() throws InterruptedException {
        // CHROME
        ChromeDriverService chromeDriverService = new ChromeDriverService
                .Builder()
                .usingDriverExecutable(new File("D:\\garbage\\web-drivers\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();

        WebDriver driver = new ChromeDriver(chromeDriverService);
        driver.manage().window().maximize();

        driver.navigate().to("https://gravitymvctestapplication.azurewebsites.net/");
        driver.findElement(By.xpath("//a[.='Students']")).click();
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void selectElementSamples() throws InterruptedException {
        // CHROME
        ChromeDriverService chromeDriverService = new ChromeDriverService
                .Builder()
                .usingDriverExecutable(new File("D:\\garbage\\web-drivers\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();

        WebDriver driver = new ChromeDriver(chromeDriverService);
        driver.manage().window().maximize();

        driver.navigate().to("https://gravitymvctestapplication.azurewebsites.net/Course");
        WebElement element = driver.findElement(By.xpath("//select[@id='SelectedDepartment']"));
        Select selectElement = new Select(element);
        selectElement.selectByValue("4");
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void webDriverFactorySamples() throws InterruptedException, MalformedURLException {
        WebDriver driver = new WebDriverFactory(new DriverParams().setDriver("edge").setBinaries("D:\\automation-env\\web-drivers")).get();
        driver.manage().window().maximize();

        driver.navigate().to("https://gravitymvctestapplication.azurewebsites.net/");
        driver.findElement(By.xpath("//a[.='Students']")).click();
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void goToUrlSample() throws InterruptedException, MalformedURLException {
        WebDriver driver = new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("D:\\automation-env\\web-drivers")).get();

        // extension object
        WebDriverExtensions driverExtensions = new WebDriverExtensions(driver);

        driverExtensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/");
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void getElementSample() throws InterruptedException, MalformedURLException {
        WebDriver driver = new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("D:\\automation-env\\web-drivers")).get();

        // extension object
        WebDriverExtensions driverExtensions = new WebDriverExtensions(driver);

        driverExtensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/");
        driverExtensions.getElement(By.xpath("//a[.='Students']")).click();
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void asSelectSample() throws InterruptedException, MalformedURLException {
        WebDriver driver = new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("D:\\automation-env\\web-drivers")).get();

        // extension object
        WebDriverExtensions driverExtensions = new WebDriverExtensions(driver);

        driverExtensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/Course");
        WebElement element = driverExtensions.getElement(By.xpath("//select[@id='SelectedDepartment']"));
        driverExtensions.asSelect(element).selectByValue("4");
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void getElementsSample() throws InterruptedException, MalformedURLException {
        WebDriver driver = new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("D:\\automation-env\\web-drivers")).get();

        // extension object
        WebDriverExtensions driverExtensions = new WebDriverExtensions(driver);

        driverExtensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/");
        List<WebElement> element = driverExtensions.getElements(By.xpath("//ul/li"));
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void getVisibleElementSample() throws InterruptedException, MalformedURLException {
        WebDriver driver = new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("D:\\automation-env\\web-drivers")).get();

        // extension object
        WebDriverExtensions driverExtensions = new WebDriverExtensions(driver);

        driverExtensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/");
        driverExtensions.getVisibleElement(By.xpath("//a[.='Students']")).click();
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void getVisibleElementsSample() throws InterruptedException, MalformedURLException {
        WebDriver driver = new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("D:\\automation-env\\web-drivers")).get();

        // extension object
        WebDriverExtensions driverExtensions = new WebDriverExtensions(driver);

        driverExtensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/");
        List<WebElement> element = driverExtensions.getVisibleElements(By.xpath("//ul/li"));
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void getEnabledElementSample() throws InterruptedException, MalformedURLException {
        WebDriver driver = new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("D:\\automation-env\\web-drivers")).get();

        // extension object
        WebDriverExtensions driverExtensions = new WebDriverExtensions(driver);

        driverExtensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/Student");
        driverExtensions.getEnabledElement(By.xpath("//input[@id='SearchString']")).sendKeys("hello");
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void verticalWindowScrollSample() throws InterruptedException, MalformedURLException {
        WebDriver driver = new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("D:\\automation-env\\web-drivers")).get();

        // extension object
        WebDriverExtensions driverExtensions = new WebDriverExtensions(driver);

        driverExtensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/Student");
        driver.manage().window().setSize(new Dimension(100, 350));
        driverExtensions.verticalWindowScroll(1000);
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void getActionsSample() throws InterruptedException, MalformedURLException {
        WebDriver driver = new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("D:\\automation-env\\web-drivers")).get();

        // extension object
        WebDriverExtensions driverExtensions = new WebDriverExtensions(driver);

        driverExtensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/");
        WebElement element = driverExtensions.getVisibleElement(By.xpath("//a[.='Students']"));
        driverExtensions.getActions(element).click().build().perform();
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void forceClickSample() throws InterruptedException, MalformedURLException {
        WebDriver driver = new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("D:\\automation-env\\web-drivers")).get();

        // extension object
        WebDriverExtensions driverExtensions = new WebDriverExtensions(driver);

        driverExtensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/");
        WebElement element = driverExtensions.getElement(By.xpath("//a[.='Students']"));
        driverExtensions.forceClick(element);
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void sendKeysIntervalSample() throws InterruptedException, MalformedURLException {
        WebDriver driver = new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("D:\\automation-env\\web-drivers")).get();

        // extension object
        WebDriverExtensions driverExtensions = new WebDriverExtensions(driver);

        driverExtensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/Student");
        WebElement element = driverExtensions.getEnabledElement(By.xpath("//input[@id='SearchString']"));
        driverExtensions.sendKeys(element, "hello", 1000);
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void forceClearSample() throws InterruptedException, MalformedURLException {
        WebDriver driver = new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("D:\\automation-env\\web-drivers")).get();

        // extension object
        WebDriverExtensions driverExtensions = new WebDriverExtensions(driver);

        driverExtensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/Student");
        WebElement element = driverExtensions.getEnabledElement(By.xpath("//input[@id='SearchString']"));
        driverExtensions.sendKeys(element, "hello", 0).sendKeys(Keys.HOME);

        driverExtensions.forceClear(element);
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void submitFormSample() throws InterruptedException, MalformedURLException {
        WebDriver driver = new WebDriverFactory(new DriverParams().setDriver("chrome").setBinaries("D:\\automation-env\\web-drivers")).get();

        // extension object
        WebDriverExtensions driverExtensions = new WebDriverExtensions(driver);

        driverExtensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/Student");
        WebElement element = driverExtensions.getEnabledElement(By.xpath("//input[@id='SearchString']"));
        element.sendKeys("Alexander");
        driverExtensions.submitForm(0);
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void goToUrlRemoteSample() throws InterruptedException, MalformedURLException {
        WebDriver driver = new WebDriverFactory(new DriverParams().setDriver("chrome").setSource("remote").setBinaries("http://localhost:4444/wd/hub")).get();

        // extension object
        WebDriverExtensions driverExtensions = new WebDriverExtensions(driver);

        driverExtensions.goToUrl("https://gravitymvctestapplication.azurewebsites.net/");
        Thread.sleep(2000);
        driver.quit();
    }
}