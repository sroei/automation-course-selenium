using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Text;

namespace Automation.Extensions.Components
{
    public static class WebDriverExtensions
    {
        public static IWebDriver GoToUrl(this IWebDriver driver, string url)
        {
            // actions
            driver.Navigate().GoToUrl(url);
            driver.Manage().Window.Maximize();

            // fluent
            return driver;
        }
    }
}
