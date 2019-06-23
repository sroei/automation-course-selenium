using Automation.Extensions.Components;
using Automation.Extensions.Contracts;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.IE;
using OpenQA.Selenium.Support.UI;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Automation.Testing
{
    [TestClass]
    public class SeleniumSamples
    {
        [TestMethod]
        public void WebDriverSamples()
        {
            IWebDriver driver = new ChromeDriver();
            Thread.Sleep(1000);
            driver.Dispose();

            driver = new FirefoxDriver();
            Thread.Sleep(1000);
            driver.Dispose();

            driver = new InternetExplorerDriver();
            Thread.Sleep(1000);
            driver.Dispose();
        }

        [TestMethod]
        public void WebElementSamples()
        {
            var driver = new ChromeDriver();
            driver.Manage().Window.Maximize();

            driver.Navigate().GoToUrl("https://gravitymvctestapplication.azurewebsites.net/");
            driver.FindElement(By.XPath("//a[.='Students']")).Click();
            Thread.Sleep(2000);
            driver.Dispose();
        }

        [TestMethod]
        public void SelectElementSamples()
        {
            var driver = new ChromeDriver();
            driver.Manage().Window.Maximize();

            driver.Navigate().GoToUrl("https://gravitymvctestapplication.azurewebsites.net/Course");
            var element = driver.FindElement(By.XPath("//select[@id='SelectedDepartment']"));
            var selectElement = new SelectElement(element);
            selectElement.SelectByValue("4");
            Thread.Sleep(2000);
            driver.Dispose();
        }

        [TestMethod]
        public void WebDriverFactorySample()
        {
            var driver = new WebDriverFactory(new DriverParams { Driver = "edge", Binaries = @"D:\automation-env\web-drivers" }).Get();
            driver.Manage().Window.Maximize();

            driver.Navigate().GoToUrl("https://gravitymvctestapplication.azurewebsites.net/");
            driver.FindElement(By.XPath("//a[.='Students']")).Click();
            Thread.Sleep(2000);
            driver.Dispose();
        }

        [TestMethod]
        public void GoToUrlSample()
        {
            var driver = new WebDriverFactory(new DriverParams { Driver = "chrome", Binaries = @"D:\automation-env\web-drivers" }).Get();

            driver.GoToUrl("https://gravitymvctestapplication.azurewebsites.net/");
            Thread.Sleep(2000);
            driver.Dispose();
        }

        [TestMethod]
        public void GetElementSample()
        {
            var driver = new WebDriverFactory(new DriverParams { Driver = "chrome", Binaries = @"D:\automation-env\web-drivers" }).Get();
            driver.Manage().Window.Maximize();

            driver.Navigate().GoToUrl("https://gravitymvctestapplication.azurewebsites.net/");
            driver.GetElement(By.XPath("//a[.='Students']")).Click();
            Thread.Sleep(2000);
            driver.Dispose();
        }

        [TestMethod]
        public void AsSelectSample()
        {
            var driver = new WebDriverFactory(new DriverParams { Driver = "chrome", Binaries = @"D:\automation-env\web-drivers" }).Get();
            driver.Manage().Window.Maximize();

            driver.Navigate().GoToUrl("https://gravitymvctestapplication.azurewebsites.net/Course");
            driver.FindElement(By.XPath("//select[@id='SelectedDepartment']")).AsSelect().SelectByValue("4");
            Thread.Sleep(2000);
            driver.Dispose();
        }

        [TestMethod]
        public void GetElementsSample()
        {
            var driver = new WebDriverFactory(new DriverParams { Driver = "chrome", Binaries = @"D:\automation-env\web-drivers" }).Get();

            driver.GoToUrl("https://gravitymvctestapplication.azurewebsites.net/");
            var elements = driver.GetElements(By.XPath("//ul/li"));
            Thread.Sleep(2000);
            driver.Dispose();
        }

        [TestMethod]
        public void GetVisibleElementSample()
        {
            var driver = new WebDriverFactory(new DriverParams { Driver = "chrome", Binaries = @"D:\automation-env\web-drivers" }).Get();

            driver.GoToUrl("https://gravitymvctestapplication.azurewebsites.net/");
            driver.GetVisibleElement(By.XPath("//a[.='Students']")).Click();
            Thread.Sleep(2000);
            driver.Dispose();
        }

        [TestMethod]
        public void GetVisibleElementsSample()
        {
            var driver = new WebDriverFactory(new DriverParams { Driver = "chrome", Binaries = @"D:\automation-env\web-drivers" }).Get();

            driver.GoToUrl("https://gravitymvctestapplication.azurewebsites.net/");
            var elements = driver.GetVisibleElements(By.XPath("//ul/li"));
            Thread.Sleep(2000);
            driver.Dispose();
        }

        [TestMethod]
        public void GetEnabledElementSample()
        {
            var driver = new WebDriverFactory(new DriverParams { Driver = "chrome", Binaries = @"D:\automation-env\web-drivers" }).Get();

            driver.GoToUrl("https://gravitymvctestapplication.azurewebsites.net/Student");
            driver.GetEnabledElement(By.XPath("//input[@id='SearchString']")).SendKeys("hello");
            Thread.Sleep(2000);
            driver.Dispose();
        }

        [TestMethod]
        public void VerticalWindowScrollSample()
        {
            var driver = new WebDriverFactory(new DriverParams { Driver = "chrome", Binaries = @"D:\automation-env\web-drivers" }).Get();

            driver.GoToUrl("https://gravitymvctestapplication.azurewebsites.net/Student");
            driver.Manage().Window.Size = new Size(100, 350);
            driver.VerticalWindowScroll(1000);
            Thread.Sleep(2000);
            driver.Dispose();
        }

        [TestMethod]
        public void ActionsSample()
        {
            var driver = new WebDriverFactory(new DriverParams { Driver = "chrome", Binaries = @"D:\automation-env\web-drivers" }).Get();

            driver.GoToUrl("https://gravitymvctestapplication.azurewebsites.net/");
            driver.GetVisibleElement(By.XPath("//a[.='Students']")).Actions().Click().Build().Perform();
            Thread.Sleep(2000);
            driver.Dispose();
        }

        [TestMethod]
        public void ForceClickSample()
        {
            var driver = new WebDriverFactory(new DriverParams { Driver = "chrome", Binaries = @"D:\automation-env\web-drivers" }).Get();
            driver.Manage().Window.Maximize();

            driver.Navigate().GoToUrl("https://gravitymvctestapplication.azurewebsites.net/");
            driver.GetElement(By.XPath("//a[.='Students']")).ForceClick();
            Thread.Sleep(2000);
            driver.Dispose();
        }

        [TestMethod]
        public void SendKeysIntervalSample()
        {
            var driver = new WebDriverFactory(new DriverParams { Driver = "chrome", Binaries = @"D:\automation-env\web-drivers" }).Get();

            driver.GoToUrl("https://gravitymvctestapplication.azurewebsites.net/Student");
            driver.GetEnabledElement(By.XPath("//input[@id='SearchString']")).SendKeys("hello", 1000);
            Thread.Sleep(2000);
            driver.Dispose();
        }
    }
}
